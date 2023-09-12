/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.service;

import com.ptk.pojo.PostComment;
import com.ptk.pojo.Posts;
import com.ptk.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface PostCommentService {

    List<PostComment> getListComment(Map<String, String> params);
    
    List<PostComment> getCommentByPostId(int id, Map<String, String> params);

    int countComment();

    int countComment(int id);

    boolean addOrUpdateComment(PostComment pc);

    boolean deleteComment(int id);

    PostComment getCommentById(int id);
}
