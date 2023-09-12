/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.Cart;
import com.ptk.repository.ReceiptRepository;
import com.ptk.service.ReceiptService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepository receiptRepository;
    
    @Override
    public boolean addReceipt(Map<String, Cart> carts) {
        return this.receiptRepository.addReceipt(carts);
    }
    
}
