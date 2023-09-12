/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Posts;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface PostRepository {
    List<Posts> getListPost(Map<String, String> params);

    int countPost();

    boolean addOrUpdatePost(Posts p);
    
     boolean deletePost(int id);
    
    Posts getPostById(int id);
}
