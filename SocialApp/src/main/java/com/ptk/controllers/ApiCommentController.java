/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.Cart;
import com.ptk.pojo.PostComment;
import com.ptk.pojo.Posts;
import com.ptk.service.PostCommentService;
import com.ptk.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kien
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    
     
    @Autowired
    private PostCommentService postCommentService;
    
    @DeleteMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.postCommentService.deleteComment(id);
    }
    
    @RequestMapping("/comments/")
    @CrossOrigin
    public ResponseEntity<List<PostComment>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.postCommentService.getListComment(params), HttpStatus.OK);
    }
    @RequestMapping("/commentsByPostId/{postId}")
    @CrossOrigin
    public ResponseEntity<List<PostComment>> listCommentByPostId(@RequestParam Map<String, String> params, 
                                                                @PathVariable(value = "postId") int id) {
        return new ResponseEntity<>(this.postCommentService.getCommentByPostId(id, params), HttpStatus.OK);
    }
    
    
    @RequestMapping(path = "/comments/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<PostComment> details(@PathVariable(value = "commentId") int id) {
        return new ResponseEntity<>(this.postCommentService.getCommentById(id), HttpStatus.OK);
    }
    
    
 
//    @PostMapping("/newComment/")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin
//    public void add(@RequestBody Map< PostComment> comment) {
//        this.postCommentService.addOrUpdateComment(comment);
//    }
}
