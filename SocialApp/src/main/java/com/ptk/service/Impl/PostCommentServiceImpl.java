/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.service.Impl;

import com.ptk.pojo.PostComment;
import com.ptk.pojo.Posts;
import com.ptk.pojo.Users;
import com.ptk.repository.PostCommentRepository;
import com.ptk.service.PostCommentService;
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
public class PostCommentServiceImpl implements PostCommentService{

    
    @Autowired
    private PostCommentRepository postCommentRepo;
    
    @Override
    public List<PostComment> getListComment(Map<String, String> params) {
        return this.postCommentRepo.getListComment(params);
    }

    @Override
    public int countComment() {
        return this.postCommentRepo.countComment();  
    }

    @Override
    public boolean addOrUpdateComment(PostComment pc) {
        
        return this.postCommentRepo.addOrUpdateComment(pc);
     }

    @Override
    public boolean deleteComment(int id) {
        return this.postCommentRepo.deleteComment(id);
    }

    @Override
    public PostComment getCommentById(int id) {
        return this.postCommentRepo.getCommentById(id);
    }

    @Override
    public int countComment(int id) {
           return this.postCommentRepo.countComment(id);  
    }

    @Override
    public List<PostComment> getCommentByPostId(int id, Map<String, String> params) {
         return this.postCommentRepo.getCommentByPostId(id, params);
    }
    
}
