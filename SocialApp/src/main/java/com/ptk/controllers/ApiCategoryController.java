
package com.ptk.controllers;

import com.ptk.pojo.Categories;
import com.ptk.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kien
 */
@RestController
@RequestMapping("/api")
public class ApiCategoryController {
    @Autowired
    public CategoryService cateService;
    
    @GetMapping("/categories/")
    //để bên phía domain gọi được, để không thì domain nào cũng truy cập được
    @CrossOrigin()//(origins = ("127...."))
    public ResponseEntity<List<Categories>> list() {
        return new ResponseEntity<>(this.cateService.getCategories(), HttpStatus.OK);
    }
}