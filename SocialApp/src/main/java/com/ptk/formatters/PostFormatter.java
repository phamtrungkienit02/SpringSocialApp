/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.formatters;

import com.ptk.pojo.Posts;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Kien
 */
public class PostFormatter implements Formatter<Posts>{
     //tra tu java ra template
    @Override
    public String print(Posts p, Locale locale) {
        return String.valueOf(p.getId());    
    }

    //ngc lai
    @Override
    public Posts parse(String postId, Locale locale) throws ParseException {
        return new Posts(Integer.parseInt(postId));
    }
}
