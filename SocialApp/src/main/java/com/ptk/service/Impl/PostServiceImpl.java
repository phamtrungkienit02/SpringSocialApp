/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.cloudinary.Cloudinary;
import com.ptk.pojo.Posts;
import com.ptk.pojo.Users;
import com.ptk.repository.PostRepository;
import com.ptk.service.PostService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Cloudinary cloudinary;

    
    @Override
    public List<Posts> getListPost(Map<String, String> params) {
        return this.postRepository.getListPost(params);
    }

    @Override
    public int countPost() {
        return this.postRepository.countPost();
    }

    @Override
    public boolean addOrUpdatePost(Posts p) {
 
        return this.postRepository.addOrUpdatePost(p);
    }

    @Override
    public boolean deletePost(int id) {
         return this.postRepository.deletePost(id);
    }

    @Override
    public Posts getPostById(int id) {
         return this.postRepository.getPostById(id);
    }

   
}
