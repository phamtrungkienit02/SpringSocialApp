/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.pojo.Results;
import com.ptk.repository.ResultRepository;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
@Repository
@Transactional
public class ResultRepositoryImpl implements ResultRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addResult(Results rs) {
         try {
            Session s = this.factory.getObject().getCurrentSession();
            //dang upload
            if (rs.getId() == null) {
                rs.setTime(new Date());
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
