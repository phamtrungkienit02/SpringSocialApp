/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.service;

import com.ptk.pojo.Products;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface ProductService {
     List<Products> getProducts(Map<String, String> params);
     int countProduct();
     boolean addOrUpdateProduct(Products p);
      boolean deleteProduct(int id);
     Products getProductById(int id);
}
