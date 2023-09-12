package com.ptk.controllers;

//import com.mysql.cj.Session;
import com.ptk.pojo.Users;
import com.ptk.service.CategoryService;
import com.ptk.service.PostCommentService;
import com.ptk.service.PostService;
import com.ptk.service.ProductService;
import com.ptk.service.UserService;
import java.security.Principal;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kien
 */
//sd cho controller khac
@ControllerAdvice

@Controller
@PropertySource("classpath:configs.properties")
// tuyệt đối khoông new service
public class IndexController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    //biến môi trường là unit
    @Autowired
    private Environment env;
//        
//    @Transactional

    @RequestMapping("/")
    //mặc định requesstparam là phải truyền tham số, required không bắt buộc
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("posts", this.postService.getListPost(params));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_POST"));
        int count = this.postService.countPost();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));

        return "index";
    }

    //attribute xuất hiện ở mọi response
    @ModelAttribute
    public void commonAttri(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("users", this.userService.getUsers());
        
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null ) {
            String username = authentication.getName();
//            this.userService.getUserByUn(username)
            model.addAttribute("currentUser",            this.userService.getUserByUn(username));
        }
        

    }
}
