/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.formatters;

import com.ptk.pojo.AuctionProduct;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Kien
 */
public class AutionProductFormatter implements Formatter<AuctionProduct>{

    //tra tu java ra template
    @Override
    public String print(AuctionProduct cate, Locale locale) {
        return String.valueOf(cate.getId());    
    }

    //ngc lai
    @Override
    public AuctionProduct parse(String auProId, Locale locale) throws ParseException {
        return new AuctionProduct(Integer.parseInt(auProId));
    }
}
