/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptk.repository;

import com.ptk.pojo.Notifications;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kien
 */
public interface NotifacationRepository {
//    List<Notifications> getListNotification(Map<String, String> params);

//    int countComment();
    
    int countNotification(int postId);
    
    List<Notifications> getCommentByUserId(int userId);

    boolean addNotification(Notifications n);
    
    boolean deleteComment(int id);
    
//    PostComment getCommentById(int id);
}
