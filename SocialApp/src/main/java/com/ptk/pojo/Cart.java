/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.pojo;

import java.math.BigDecimal;
import lombok.Data;


/**
 *
 * @author admin
 */
//tự sinh getter setter
@Data
public class Cart {
    private Long id;
    private String name;
    private int quantity;
    private BigDecimal unitPrice;
}
