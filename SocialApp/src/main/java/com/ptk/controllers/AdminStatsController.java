/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.controllers;

import com.itextpdf.text.pdf.PdfWriter;
import com.ptk.service.ProductService;
import com.ptk.service.StatsService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Kien
 */
@Controller
public class AdminStatsController {
    
    @Autowired
    private StatsService statsService;
   
    
    @RequestMapping("/admin/stats")
    public String index(Model model, @RequestParam Map<String, String> params) throws IOException{
        
 
        model.addAttribute("listProduct", this.statsService.countProductByCates());
        model.addAttribute("listTop5Product", this.statsService.listTopProduct());
        model.addAttribute("listTop5PostByComment", this.statsService.listTopPostByComment());
        model.addAttribute("listTop5PostByLike", this.statsService.listTopPostByLike());
        return "adminStats";
    }
    
    
    
//    @PostMapping("/download-pdf")
//    public void downloadPdf(HttpServletResponse response) throws Exception {
//        String url = "http://localhost:8080/ten-trang-jsp";
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document() {};
//        PdfWriter writer = PdfWriter.getInstance(document, baos);
//        document.open();
//        InputStream is = new ByteArrayInputStream(html.getBytes());
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
//        document.close();
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "attachment; filename=output.pdf");
//        response.setContentLength(baos.size());
//        OutputStream outputStream = response.getOutputStream();
//        baos.writeTo(outputStream);
//        outputStream.flush();
//        }
    
}
