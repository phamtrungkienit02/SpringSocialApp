/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.pojo.Categories;
import com.ptk.pojo.Users;
import com.ptk.repository.CategoryRepository;
import com.ptk.repository.UserRepository;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private BCryptPasswordEncoder passEncoder;


    @Override
   
    public List<Users> getUsers() {
       Session s  = factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Users");
        
        return q.getResultList();
    }

    @Override
    public Users getUserByUsername(String username) {
      Session s  = factory.getObject().getCurrentSession();
       Query q = s.createQuery("FROM Users WHERE username=:un");
       
       q.setParameter("un", username);
       
       //nhiều cũng trả 1 user
      try {
        return (Users) q.getSingleResult();
    } catch (NoResultException ex) {
        return null;
    }
}
    
    
    //chứng thực username password
    @Override
    public boolean authUser(String username, String password) {
        Users  u = this.getUserByUsername(username);
        
        //kiểm tra mật khẩu đã được băm và mật khẩu client truyền vào
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public Users addUser(Users u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(u);
        
        return u;
    }

    @Override
    public boolean addOrUpdateUser(Users user) {
      try {
            Session s = this.factory.getObject().getCurrentSession();
            //dang upload
            if (user.getId() == null) {
                s.save(user);
            } else {
                s.update(user);
            }
            return true;
            // ngoại lệ ràng buộc
        } catch (HibernateException ex) {
//            ex.printStackTrace();
            return false;
        }}
    
}
