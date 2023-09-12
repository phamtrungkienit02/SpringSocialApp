/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.formatters;

import com.ptk.pojo.Categories;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Kien
 */
public class CategoryFormatter implements Formatter<Categories>{

    //tra tu java ra template
    @Override
    public String print(Categories cate, Locale locale) {
        return String.valueOf(cate.getId());    
    }

    //ngc lai
    @Override
    public Categories parse(String cateId, Locale locale) throws ParseException {
        return new Categories(Integer.parseInt(cateId));
    }
    
    
}
