/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.repository.StatsRepository;
import com.ptk.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class StatsServiceImpl implements StatsService{

     @Autowired
    private StatsRepository statsRepo;
    
    @Override
    public List<Object[]> countProductByCates() {
        return this.statsRepo.countProductByCates();
    }

    @Override
    public List<Object[]> listTopProduct() {
        return this.statsRepo.listTopProduct();
    }

    @Override
    public List<Object[]> listTopPostByComment() {
        return this.statsRepo.listTopPostByComment();
    }

    @Override
    public List<Object[]> listTopPostByLike() {
        return this.statsRepo.listTopPostByLike();
    }
 
}
