/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Cart;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface ReceiptRepository {
    boolean addReceipt(Map<String, Cart> carts);
}
