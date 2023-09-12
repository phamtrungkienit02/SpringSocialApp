/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.mysql.cj.xdevapi.Result;
import com.ptk.pojo.Categories;
import com.ptk.pojo.PostComment;
import com.ptk.pojo.PostLike;
import com.ptk.pojo.Posts;
import com.ptk.pojo.Products;
import com.ptk.pojo.Users;
import com.ptk.repository.StatsRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
//    @Autowired
//    private SimpleDateFormat f;

    public List<Object[]> countProductByCates() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rProd = q.from(Products.class);
        Root rCate = q.from(Categories.class);

        q.where(b.equal(rProd.get("categoryId"), rCate.get("id")));
        q.multiselect(rCate.get("id"), rCate.get("name"), b.count(rProd.get("id")));
        q.groupBy(rCate.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();

    }

    public List<Object[]> statsRevenue(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rProd = q.from(Products.class);
        Root rResults = q.from(Result.class);
//            Root rOrder = q.from(SaleOrder.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rResults.get("productId"), rProd.get("id")));
//            predicates.add(b.equal(rResults.get("orderId"), rOrder.get("id")));

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(rProd.get("name"), String.format("%%%s%%", kw)));
            }

//                String fd = params.get("fromDate");
//                if (fd != null && !fd.isEmpty())
//                    try {
//                        b.greaterThanOrEqualTo(rOrder.get("createdDate"), f.parse(fd));
//                    } catch (ParseException ex) {
//                        Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                String td = params.get("toDate");
//                if (td != null && !td.isEmpty())
//                    try {
//                        b.lessThanOrEqualTo(rOrder.get("createdDate"), f.parse(td));
//                    } catch (ParseException ex) {
//                        Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                String quarter = params.get("quarter");
//                if (quarter != null && !quarter.isEmpty()) {
//                    String year = params.get("year");
//                    if (year != null && !year.isEmpty()) {
//                        predicates.add(b.equal(b.function("YEAR", Integer.class, rOrder.get("createdDate")), Integer.parseInt(year)));
//                        predicates.add(b.equal(b.function("QUARTER", Integer.class, rOrder.get("createdDate")), Integer.parseInt(quarter)));
//                    }
//                }
        }

        q.where(predicates.toArray(Predicate[]::new));
        //prod phép nhân trong csdl
//            q.multiselect(rProd.get("id"), rProd.get("name"), b.sum(b.prod(rResults.get("unitPrice"), rResults.get("num"))));
        q.multiselect(rProd.get("id"), rProd.get("name"), b.sum(rResults.get("unitPrice")));
        q.groupBy(rProd.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();

    }

    @Override
    public List<Object[]> listTopProduct() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rProduct = q.from(Products.class);
        Root rUser = q.from(Users.class);
        Root rCategory = q.from(Categories.class);

        //  b.concat(rUser.get("firstName"), " ", rUser.get("lastName")))
        q.multiselect(rProduct.get("id"), rProduct.get("name"), rProduct.get("startingPrice"), rCategory.get("name"), rUser.get("username"))
                .where(b.and(
                        b.equal(rProduct.get("categoryId"), rCategory.get("id")),
                        b.equal(rProduct.get("userId"), rUser.get("id"))
                ))
                .orderBy(b.desc(rProduct.get("startingPrice")));

        List<Object[]> results = s.createQuery(q).setMaxResults(5).getResultList();

        return results;
    }

    @Override
    public List<Object[]> listTopPostByComment() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rPost = q.from(Posts.class);
        Root rUser = q.from(Users.class);
        Root rComment = q.from(PostComment.class);

        //  b.concat(rUser.get("firstName"), " ", rUser.get("lastName")))
        q.multiselect(rPost.get("id"), rPost.get("title"), b.count(rComment.get("id")), rUser.get("username"))
                .where(b.and(
                        b.equal(rPost.get("userId"), rUser.get("id")),
                        b.equal(rPost.get("id"), rComment.get("postId"))
                ))
                .groupBy(rPost.get("id"))
                .orderBy(b.desc(b.count(rComment.get("id"))));

        List<Object[]> results = s.createQuery(q).setMaxResults(5).getResultList();

        return results;
    }

    @Override
    public List<Object[]> listTopPostByLike() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rPost = q.from(Posts.class);
        Root rUser = q.from(Users.class);
        Root rLike = q.from(PostLike.class);

        //  b.concat(rUser.get("firstName"), " ", rUser.get("lastName")))
        q.multiselect(rPost.get("id"), rPost.get("title"), b.count(rLike.get("id")), rUser.get("username"))
                .where(b.and(
                        b.equal(rPost.get("userId"), rUser.get("id")),
                        b.equal(rPost.get("id"), rLike.get("postId"))
                ))
                .groupBy(rPost.get("id"))
                .orderBy(b.desc(b.count(rLike.get("id"))));

        List<Object[]> results = s.createQuery(q).setMaxResults(5).getResultList();

        return results;
    }

}
