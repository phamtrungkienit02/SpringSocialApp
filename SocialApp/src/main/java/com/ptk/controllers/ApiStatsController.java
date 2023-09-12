/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.service.StatsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kien
 */
@RestController
@RequestMapping("/api")
public class ApiStatsController {
    @Autowired
    private StatsService statsService;
    
    @RequestMapping("/admin/stats/")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.statsService.countProductByCates(), HttpStatus.OK);
    }
    
    @RequestMapping("/admin/stats/top-5-product/")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listTop5(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.statsService.listTopProduct(), HttpStatus.OK);
    }
    
    @RequestMapping("/admin/stats/top-5-post-by-comment/")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listTop5PostByComment(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.statsService.listTopPostByComment(), HttpStatus.OK);
    }
    
    @RequestMapping("/admin/stats/top-5-post-by-like/")
    @CrossOrigin
    public ResponseEntity<List<Object[]>> listTop5PostByLike(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.statsService.listTopPostByLike(), HttpStatus.OK);
    }
    
}
