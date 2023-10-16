/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.Posts;
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
public class ApiPostController {
    
    @Autowired
    private PostService postService;
    
    @DeleteMapping("/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.postService.deletePost(id);
    }
    
    @RequestMapping("/posts/")
    @CrossOrigin
    public ResponseEntity<List<Posts>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.postService.getListPost(params), HttpStatus.OK);
    }
    @RequestMapping(path = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Posts> details(@PathVariable(value = "postId") int id) {
        return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.OK);
    }
    

////    
//    @PostMapping(path = "/posts", consumes = {
//        MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE
//    })
}
