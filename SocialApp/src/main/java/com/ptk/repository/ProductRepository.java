/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Products;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kien
 */
public interface ProductRepository {

    List<Products> getProducts(Map<String, String> params);

    int countProduct();

    boolean addOrUpdateProduct(Products p);
    
    //LUU Y THÊM RÀNG BUỘC
    boolean deleteProduct(int id);
    
    Products getProductById(int id);
    
    
}
