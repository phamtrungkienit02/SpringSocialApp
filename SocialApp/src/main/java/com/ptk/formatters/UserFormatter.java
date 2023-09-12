/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.formatters;


import com.ptk.pojo.Users;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Kien
 */
public class UserFormatter implements Formatter<Users>{

    //tra tu java ra template
    @Override
    public String print(Users user, Locale locale) {
        return String.valueOf(user.getId());    
    }

    //ngc lai
    @Override
    public Users parse(String userId, Locale locale) throws ParseException {
        return new Users(Integer.parseInt(userId));
    }
    
    
}
