/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.AuctionProduct;
import com.ptk.repository.AuctionRepository;
import org.springframework.stereotype.Service;
import com.ptk.service.AuctionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kien
 */
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public List<Object[]> currentAution(int productId) {
        return this.auctionRepository.currentAution(productId);
    }

    @Override
    public  boolean addAution(AuctionProduct rs) {
        return this.auctionRepository.addAution(rs);
    }
}
