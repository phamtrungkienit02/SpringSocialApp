/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.controllers.ProductAutionController;
import com.ptk.pojo.AuctionProduct;
import com.ptk.pojo.Products;
import com.ptk.pojo.Users;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.ptk.repository.AuctionRepository;
import java.util.Date;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
@Repository
@Transactional
public class AuctionRepositoryImpl implements AuctionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> currentAution(int productId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rProd = q.from(Products.class);
        Root rAuction = q.from(AuctionProduct.class);
        Root rUser = q.from(Users.class);
//        Root rUserProduct = q.from(Users.class);

        q.multiselect(rAuction.get("id"), rProd.get("name"), rAuction.get("currentPrice"), rUser.get("username"), rUser.get("id"), rProd.get("id"))
                .where(b.and(
                        b.equal(rAuction.get("productId"), productId),
                        b.equal(rAuction.get("userId"), rUser.get("id")),
                        b.equal(rAuction.get("productId"), rProd.get("id"))
                ))
                //            .groupBy(rAution.get("productId"))
                .orderBy(b.desc(rAuction.get("currentPrice")));

        List<Object[]> results = s.createQuery(q).setMaxResults(5).getResultList();
//        List<Object[]> results = s.createQuery(q).getResultList();
        return results;
    }

    @Override
    public boolean addAution(AuctionProduct rs) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            //dang upload
            if (rs.getId() == null) {
                rs.setCreatedAt(new Date());
                s.save(rs);

            }
            return true;
            // ngoại lệ ràng buộc
        } catch (HibernateException ex) {
//            ex.printStackTrace();
            return false;

        }
    }
}
