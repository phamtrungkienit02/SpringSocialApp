/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.AuctionProduct;
import java.util.List;

/**
 *
 * @author Kien
 */
public interface AuctionRepository {
     public List<Object[]> currentAution(int productId) ;
     boolean addAution(AuctionProduct rs);
}
