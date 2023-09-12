
package com.ptk.controllers;


//import com.mysql.cj.Session;
import com.ptk.pojo.Users;
import com.ptk.service.CategoryService;
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

////sd cho controller khac
//@ControllerAdvice

@Controller
@PropertySource("classpath:configs.properties")
// tuyệt đối khoông new service
public class ListProductController {
    @Autowired
    private ProductService productService;
    
//    @Autowired
//    private CategoryService categoryService;
    
    @Autowired
    private UserService userService;
    
    //biến môi trường là unit
    @Autowired
    private Environment env;
//        
//    @Transactional
    @RequestMapping("/list-product")
    //mặc định requesstparam là phải truyền tham số, required không bắt buộc
    public String index(Model model,
//            @RequestParam(value = "fName", required = false, defaultValue = "Trung") String fName,
//            @RequestParam(value = "lName", required = false, defaultValue = "Kien") String lName){
//        //sử dụng request param mặc định phải truyền lên
            
            //sử dụng trong trường có quá nhiều tham số
            @RequestParam Map<String, String> params){
        
        String fName = params.get("fName");
        String lName = params.get("lName");
        
        if (fName != null && lName != null)
            model.addAttribute("name", String.format("%s %s", fName, lName));
        else
            model.addAttribute("name", "default");
        model.addAttribute("user", new Users());
        
        //thm
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Products");
//        model.addAttribute("products", q.getResultList());

        model.addAttribute("products", this.productService.getProducts(params));
//        model.addAttribute("categories", this.categoryService.getCategories());
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.productService.countProduct();
        //lam tron len; lấy số sản phẩm / số sản phảm 1 trang; 1.2 => 2 trang
        model.addAttribute("counter", Math.ceil(count*1.0/pageSize));
        
        return "listProduct";
    }
    
//    //attribute xuất hiện ở mọi response
//    @ModelAttribute
//    public void commonAttri(Model model){
//         model.addAttribute("categories", this.categoryService.getCategories());
//         model.addAttribute("users", this.userService.getUsers());
//    }
    
    
    // path param
    // /hello: path; name là value đặt trong{}
    // {} và value đặt tên giống nhau
    // bản chất là get
    @RequestMapping("/hello/{name}")
    public String hello(Model model,
            @PathVariable(value = "name") String name){
        //cách để truyền từ server ra client
        model.addAttribute("message", "Welcome " + name);
        
        return "hello";
    }
    
    @RequestMapping(path = "/hello-post", method = RequestMethod.POST)
    public String show(Model model, @ModelAttribute(value = "user") Users user){
        model.addAttribute("fullName", user.getFirstName() + " " + user.getLastName());
        
        return "forward:/";
    }
    
    @RequestMapping(path = "/forward")
    public String foward(Model model) {
        model.addAttribute("testForward", "INDEX SAY HI");
        
        return "forward:/hello/KIEN";
    }
                                                                                                                  
}

