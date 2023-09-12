package com.ptk.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptk.pojo.Products;
import com.ptk.repository.ProductRepository;
import com.ptk.service.ProductService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Products> getProducts(Map<String, String> params) {
        return this.productRepo.getProducts(params);
    }

    @Override
    public int countProduct() {
        return this.productRepo.countProduct();
    }

    @Override
    public boolean addOrUpdateProduct(Products p) {
        //có ảnh mới upload
        if (!p.getFile().isEmpty()) {

            try {
                //upload anh

                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
        return this.productRepo.addOrUpdateProduct(p);

    }

    @Override
    public Products getProductById(int id) {
        return this.productRepo.getProductById(id);
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepo.deleteProduct(id);
    }

}
