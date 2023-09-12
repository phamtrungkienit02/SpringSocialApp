/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.Products;
import com.ptk.pojo.Users;
import com.ptk.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Kien
 */
@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String login(Model model){
        
       
        return "login";
    }
    
      //trang products, new rỗng
    @GetMapping("/register")
    public String list(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @PostMapping("/register")
    public String add(@ModelAttribute(value = "user") @Valid Users u,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.userService.addOrUpdateUser(u) == true) {
                return "forward:/login";
//                redirect
            }
        }
        return "register";
            
    }
}
