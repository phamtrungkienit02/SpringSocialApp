/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.pojo.PostComment;
import com.ptk.repository.PostCommentRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
@Transactional
@Repository
@PropertySource("classpath:configs.properties")
public class PostCommentRepositoryImpl implements PostCommentRepository{

      @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    
    @Override
    public List<PostComment> getListComment(Map<String, String> params) {
         Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<PostComment> q = b.createQuery(PostComment.class);
        Root root = q.from(PostComment.class);
        q.select(root);

//        if (params != null) {
//            List<Predicate> predicates = new ArrayList<>();
//
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(root.get("title"), String.format("%%%s%%", kw)));
//            }
//
//            q.where(predicates.toArray(Predicate[]::new));
//        }

        q.orderBy(b.desc(root.get("postId")));

        Query query = s.createQuery(q);
//
//        if (params != null) {
//            String page = params.get("page");
//            if (page != null) {
//                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_COMMENT"));
//                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
//                query.setMaxResults(pageSize);
//            }
//        }

        return query.getResultList();
     }

    @Override
    public int countComment() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM PostComment");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateComment(PostComment p) {
    try {
            Session s = this.factory.getObject().getCurrentSession();
            //dang upload
            if (p.getId() == null) {
                p.setCreatedAt(new Date());
                s.save(p);
            } else {
                p.setUpdatedAt(new Date());
                s.update(p);
            }
            return true;
            // ngoại lệ ràng buộc
        } catch (HibernateException ex) {
//            ex.printStackTrace();
            return false;
        }  
    }

    @Override
    public boolean deleteComment(int id) {
       Session s = this.factory.getObject().getCurrentSession();
        try {
            PostComment p = this.getCommentById(id);
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } 
    }

    @Override
    public PostComment getCommentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(PostComment.class, id);
   }

    @Override
    public int countComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM PostComment WHERE postId.id =:id");
        q.setParameter("id", id);

        Object result = q.getSingleResult();
        
        return result != null ? Integer.parseInt(result.toString()) : 0;
    
    }


    @Override
    public List<PostComment> getCommentByPostId(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<PostComment> q = b.createQuery(PostComment.class);
        Root root = q.from(PostComment.class);
        
        q = q.where(b.equal(root.get("postId"), id));
        q = q.orderBy(b.desc(root.get("id")));
        
        Query query = s.createQuery(q);
        
         if (params != null) {
            String page = params.get("page");
            if (page != null) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_COMMENT"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }
        
        return query.getResultList();
    }
    
}
