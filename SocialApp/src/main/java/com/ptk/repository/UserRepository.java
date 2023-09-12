/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Users;
import java.util.List;

/**
 *
 * @author Kien
 */
public interface UserRepository {
     List<Users> getUsers();
     
     public Users getUserByUsername(String username);
     
    boolean authUser(String username, String password);
    
    Users addUser(Users user);
    
    boolean addOrUpdateUser(Users user);
}
