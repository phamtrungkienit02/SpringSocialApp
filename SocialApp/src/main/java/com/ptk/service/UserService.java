/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.service;

import com.ptk.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Kien
 */
public interface UserService extends UserDetailsService{
    List<Users> getUsers();
    
    Users getUserByUn(String username);
    boolean authUser(String username, String password);
    Users addUser(Map<String, String> params, MultipartFile avatar);
    boolean addOrUpdateUser(Users user);
}
