/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.PostComment;
import com.ptk.pojo.PostLike;
import com.ptk.pojo.Posts;
import com.ptk.pojo.Users;
import com.ptk.service.PostCommentService;
import com.ptk.service.PostLikeService;
import com.ptk.service.PostService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kien
 */
@Controller
@PropertySource("classpath:configs.properties")
public class PostController {
    //biến môi trường là unit
    @Autowired
    private Environment env;
    
    @Autowired
    private PostService postService;

    @Autowired
    private PostLikeService postLikeService;
    
    @Autowired
    private PostCommentService postCommentService;
    
    

    //trang posts, new rỗng
    @GetMapping("/post/new-post")
    public String newPost(Model model) {
        model.addAttribute("post", new Posts());
        return "newPost";
    }

    @PostMapping(value = "/post/new-post")
    public String addNewPost(@ModelAttribute(value = "post") @Valid Posts p,  BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.postService.addOrUpdatePost(p) == true) {
                return "redirect:/";
            }
        }
        return "newPost";
    }

    
    @GetMapping("/post/{id}")
    public String postDetail(Model model, @PathVariable(value = "id") int id, Map<String, String> params) {
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_COMMENT"));
        int count = this.postCommentService.countComment(id);
        model.addAttribute("countComment", Math.ceil(count * 1.0 / pageSize));
        
        
        model.addAttribute("comment", new PostComment());
        model.addAttribute("like", new PostLike());
        
        model.addAttribute("post", this.postService.getPostById(id));
        model.addAttribute("comments", this.postCommentService.getCommentByPostId(id, params));
        model.addAttribute("counterComment", this.postCommentService.countComment(id));
        model.addAttribute("counterLike", this.postLikeService.countLikeByPostId(id));   
        model.addAttribute("checkData", this.postLikeService.checkData(id));
            
        return "postDetail";
    }

     //api
    @GetMapping("/post/update/{id}")
    public String updatePost(Model model, @PathVariable(value = "id") int id) {
    
        model.addAttribute("post", this.postService.getPostById(id));

        return "newPost";
    }
    
    
   
    
    @PostMapping(value = "/post/add-like")
    public String addLike(@ModelAttribute(value = "like") PostLike postLike,
            HttpServletRequest request) {
        
       int i = 0;
       if (this.postLikeService.addPostLike(postLike) == true) {
                String referer = request.getHeader("referer");
                return "redirect:" + referer;
        }
        return "index";
    }
}
