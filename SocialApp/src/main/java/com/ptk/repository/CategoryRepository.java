/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Categories;
import java.util.List;

/**
 *
 * @author Kien
 */
public interface CategoryRepository {
    //phương thức trừu tượng và là public
    List<Categories> getCategories();
}
