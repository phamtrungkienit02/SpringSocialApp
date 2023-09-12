/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.repository.impl;

import com.ptk.pojo.Cart;
import com.ptk.pojo.Results;
import com.ptk.pojo.Users;
import com.ptk.repository.ReceiptRepository;
import com.ptk.repository.UserRepository;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository userRepo;
//    @Autowired
//    private ProductRepository productRepo;

    @Override
    //cần bật cái này để có thể đọc id của bảng result(cấu trúc cha con)
//    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<String, Cart> carts) {

        Session s = this.factory.getObject().getCurrentSession();
//        SaleOrder order = new SaleOrder();

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Users u = this.userRepo.getUserByUsername(authentication.getName());

            //Result là kết quả đấu giá(thành công) tương đương với hóa đơn
            //Lúc này result chưa có id
            Results result = new Results();
            result.setWinnerId(this.userRepo.getUserByUsername(authentication.getName()));
            result.setTime(new Date());
            s.save(result);

            //bỏ key
//            for (Cart c : carts.values()) {
//                OrderDetail d = new OrderDetail();
//                d.setProductId(this.productRepo.getProductById(Integer.parseInt(c.getId().toString())));
//                d.setOrderId(order);
//                d.setNum(c.getQuantity());
//                d.setUnitPrice(c.getUnitPrice());
//
//                s.save(d);
//            }
//
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
