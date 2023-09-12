/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.pojo.PostLike;
import com.ptk.pojo.Users;
import com.ptk.repository.PostLikeRepository;
import com.ptk.repository.UserRepository;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Kien
 */
@Repository
//có truy vấn dữ liệu thi tran, apply vào tran
@Transactional
public class PostLikeRepositoryImpl implements PostLikeRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository userRepo;


    @Override
    public int countLikeByPostId(int postId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM PostLike WHERE postId.id =:id");
        q.setParameter("id", postId);

        Object result = q.getSingleResult();
        
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }

    @Override
    public boolean addPostLike(PostLike pl) {
        try {

                Session s = this.factory.getObject().getCurrentSession();
               
                pl.setCreatedAt(new Date());
                s.save(pl);
                   
                return true;
            }catch (HibernateException ex) {
                ex.printStackTrace();
                return false;
            }
        
    }
 

    @Override
    public boolean deletePostLike(int postId) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            PostLike p = this.getPostLike(postId);
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } 
   }

//    @Override
//    public boolean checkLikeByPostId(int postId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    @Override
//    public boolean findPostLikeById(int postId, int userId) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query query = s.createQuery("FROM PostLike WHERE postId.id =:postId AND userId.id =:userId");
//        query.setParameter("postId", postId);
//        query.setParameter("userId", userId);
//       
//      
//        try {
//            Object result = query.getSingleResult();
//            if (Integer.parseInt(result.toString()) == 0)
//                return false;
//            return true;
//        } catch (NoResultException e) {
//            return false;
//        }
//    }

    @Override
    public boolean checkData(int postId) {
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users u = this.userRepo.getUserByUsername(authentication.getName());
    
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM PostLike WHERE postId.id =:postId AND userId.id =:userId");
        query.setParameter("postId", postId);
        query.setParameter("userId", u.getId());

        
        try {          
            Object result =(Object) query.getSingleResult();

            if (result != null) {
               return false;
            }
            return true;
        } catch (NoResultException e) {
            return true;
        }
    }   

    @Override
    public PostLike getPostLike(int postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users u = this.userRepo.getUserByUsername(authentication.getName());
        
        if (checkData(postId) == true){
            Session s = this.factory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM PostLike WHERE userId = :userId AND postId =:postId");
            q.setParameter("userId", u.getId());
            q.setParameter("postId", postId);         
            return (PostLike) q.getSingleResult();
        }
        return null;
    }
    
   
}
