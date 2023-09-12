/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.ptk.pojo.AuctionProduct;
import com.ptk.pojo.Results;
import com.ptk.service.AuctionService;
import com.ptk.service.ProductService;
import com.ptk.service.ResultService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kien
 */
@Controller
public class ProductAutionController {
    
    @Autowired
    private ProductService productService;
     @Autowired
    private AuctionService auctionService;
      @Autowired
    private ResultService resultService;
    
    
    @GetMapping("/products/aution/{id}")
    public String index(Model model, @RequestParam Map<String, String> params, @PathVariable(value = "id") int id){
 
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("currentAution", this.auctionService.currentAution(id));
        model.addAttribute("result", new Results());
        model.addAttribute("aution", new AuctionProduct());
        return "productAution";
    }
    
    @PostMapping("/products/aution/{id}/aution")
    public String addAution(@ModelAttribute(value = "aution") AuctionProduct aution, @PathVariable(value = "id") int id,
                                HttpServletRequest request){
 
        if (this.auctionService.addAution(aution) == true) {
                String referer = request.getHeader("referer");
                return "redirect:" + referer;
        } 
       
        return "listProduct";
    }
    
    @PostMapping("/products/aution/{id}/result")
    public String addResult(@ModelAttribute(value = "result") Results rs, @PathVariable(value = "id") int id,
                                HttpServletRequest request){
 
        if (this.resultService.addResult(rs) == true) {
                String referer = request.getHeader("referer");
                return "redirect:" + referer;
        } 
       
        return "listProduct";
    }
}
