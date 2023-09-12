/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.service;

import com.ptk.pojo.PostLike;

/**
 *
 * @author Kien
 */
public interface PostLikeService {

    boolean addPostLike(PostLike pl);

    int countLikeByPostId(int postId);

    boolean deletePostLike(int postId);

    boolean checkData(int postId);

    PostLike getPostLike(int postId);

}
