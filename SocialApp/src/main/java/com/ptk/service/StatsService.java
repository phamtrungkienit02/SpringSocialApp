/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.service;

import java.util.List;

/**
 *
 * @author Kien
 */
public interface StatsService {
    List<Object[]> countProductByCates();
    List<Object[]> listTopProduct();
     List<Object[]> listTopPostByComment();
     List<Object[]> listTopPostByLike();
}
