/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptk.formatters.AutionProductFormatter;
import com.ptk.formatters.CategoryFormatter;
import com.ptk.formatters.PostFormatter;
import com.ptk.formatters.ProductFormatter;
import com.ptk.formatters.UserFormatter;
import java.rmi.activation.Activatable;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Kien
 */
//khai bao cau hinh nap cac bean
@Configuration
//Hien thuc mac dinh va phuong thuc xu li mac dinh
@EnableWebMvc
//Noi chua controller
//thm
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ptk.controllers",
    "com.ptk.repository",
    "com.ptk.service"
})
@PropertySource("classpath:configs.properties")
public class WebAppContextConfig implements WebMvcConfigurer {
    
    @Autowired
    private Environment env;
    
    //Kích hoạt servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    //các thư mục tĩnh: css, image, js

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/resources/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/WEB-INF/resources/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/resources/js/");
    }
//    @Bean
//    //Build resolver
//    public InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setViewClass(JstlView.class);
//        r.setPrefix("/WEB-INF/pages/");
//        r.setSuffix(".jsp");
//        return r;
//    }
//    @Bean
//    public SimpleDateFormat simpleDateFormat(){
//        return new SimpleDateFormat("yyyy-MM-dd");
//    }

    
    // cho phép upload file, phân giải http request chứa file thanh dl, tham số đọc được
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

 
    
    //chỉ định tập tin .properites được đọc
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.addBasenames("messages");

        return m;
    }
    
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
    
    //chạy khóa ngoại tự động vào đây lấy formatter
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter()); 
        // test
        registry.addFormatter(new UserFormatter()); 
        registry.addFormatter(new PostFormatter()); 
        registry.addFormatter(new ProductFormatter()); 
        registry.addFormatter(new AutionProductFormatter()); 
    }
    
//         @Bean
//    public Cloudinary cloudinary() {
//        Cloudinary cloudinary
//                = new Cloudinary(ObjectUtils.asMap(
//                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
//                        "api_key", this.env.getProperty("cloudinary.api_key"),
//                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
//                        "secure", true));
//        return cloudinary;
//    }
//     @Bean
//    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter() {
//        FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CharacterEncodingFilter("UTF-8", true));
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setName("characterEncodingFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}