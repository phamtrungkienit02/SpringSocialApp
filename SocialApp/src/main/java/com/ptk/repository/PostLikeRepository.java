/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.PostLike;

/**
 *
 * @author Kien
 */
public interface PostLikeRepository {
    boolean addPostLike(PostLike pl);
    
    int countLikeByPostId(int postId);
    //LUU Y THÊM RÀNG BUỘC
    boolean deletePostLike(int postId);
    
//    boolean checkLikeByPostId(int postId);
    
//    boolean findPostLikeById(int postId, int userId);
    
    boolean checkData(int postId);
    
    PostLike getPostLike(int postId);
}
