/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.Results;
import com.ptk.repository.ResultRepository;
import com.ptk.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class ResultServiceImpl implements ResultService{

    @Autowired
    private ResultRepository resultRepo;
    
    @Override
    public boolean addResult(Results rs) {
        return this.resultRepo.addResult(rs);
    }
    
}
