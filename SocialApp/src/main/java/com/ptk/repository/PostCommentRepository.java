/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.PostComment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface PostCommentRepository {
     List<PostComment> getListComment(Map<String, String> params);

    int countComment();
    
    int countComment(int id);
    
    List<PostComment> getCommentByPostId(int id, Map<String, String> params);

    boolean addOrUpdateComment(PostComment p);
    
     boolean deleteComment(int id);
    
    PostComment getCommentById(int id);
}
