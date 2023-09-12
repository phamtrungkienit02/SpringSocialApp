/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptk.pojo.Products;
import com.ptk.service.Impl.ProductServiceImpl;
import com.ptk.service.ProductService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Cloudinary cloudinary;

    //trang products, new rỗng
    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", new Products());
        return "products";
    }

    ///??kt ràng buộc đầu vào>>>>>>>>>>>>>>>>>>>>>>!!!!!!!!!!!!!!!!!!!
    //Xử lý thêm sản phẩm
    @PostMapping("/products")
    public String add(@ModelAttribute(value = "products") @Valid Products p,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.productService.addOrUpdateProduct(p) == true) {
                return "redirect:/list-product";
            }
        }
        return "products";
    }

    @GetMapping("/products/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        //đối tượng product co id trên
        model.addAttribute("products", this.productService.getProductById(id));
        return "products";
    }
}
