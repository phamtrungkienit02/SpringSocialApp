/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.Categories;
import com.ptk.repository.CategoryRepository;
import com.ptk.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    //nhờ autowired từ động tạo đối tượng new repoimpl
    @Autowired
    private CategoryRepository CategoryRepository;
    
    @Override
    public List<Categories> getCategories() {
        return this.CategoryRepository.getCategories();
    }
    
}
