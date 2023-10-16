/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.formatters;

import com.ptk.pojo.Products;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 *
 * @author Kien
 */
public class ProductFormatter  implements Formatter<Products>{
     //tra tu java ra template
    @Override
    public String print(Products cate, Locale locale) {
        return String.valueOf(cate.getId());    
    }

    //ngc lai
    @Override
    public Products parse(String proId, Locale locale) throws ParseException {
        return new Products(Integer.parseInt(proId));
    }
}
