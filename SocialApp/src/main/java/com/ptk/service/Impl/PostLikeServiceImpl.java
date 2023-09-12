/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.PostLike;
import com.ptk.repository.PostLikeRepository;
import com.ptk.service.PostLikeService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kien
 */
@Service
public class PostLikeServiceImpl implements PostLikeService{

    @Autowired
    private PostLikeRepository postLikeRepo;
    @Override
    public boolean addPostLike(PostLike pl) {
        return this.postLikeRepo.addPostLike(pl);
    }

    @Override
    public int countLikeByPostId(int postId) {
        return this.postLikeRepo.countLikeByPostId(postId);
    }

    @Override
    public boolean deletePostLike(int postId) {
         return this.postLikeRepo.deletePostLike(postId);
    }

    @Override
    public boolean checkData(int postId) {
         return this.postLikeRepo.checkData(postId);
    }

    @Override
    public PostLike getPostLike(int postId) {
         return this.postLikeRepo.getPostLike(postId);
    }
    
}
