/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.PostComment;
import com.ptk.service.PostCommentService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Kien
 */
@Controller
@PropertySource("classpath:configs.properties")
public class CommentController {
    @Autowired
    private PostCommentService postCommentService;
    
    @PostMapping(value = "/post/add-comment")
    public String addComment(@ModelAttribute(value = "comment") @Valid  PostComment pc, BindingResult rs, HttpServletRequest request) {
        String referer = request.getHeader("referer");
        if (!rs.hasErrors()) {
            if (this.postCommentService.addOrUpdateComment(pc) == true) {
                return "redirect:" + referer;
                }
           }
        return "redirect:" + referer;
    }
    
//    @GetMapping("/post/comment/update/{id}")
//    public String updateCommment(Model model, @PathVariable(value = "id") int id, HttpServletRequest request) {
//        String referer = request.getHeader("referer");
//        model.addAttribute("post", this.postCommentService.getCommentById(id));
//
//        return "redirect:" + referer;
//    }
}
