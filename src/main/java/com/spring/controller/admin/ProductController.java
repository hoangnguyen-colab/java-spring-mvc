/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.admin;

import com.spring.dao.BrandDAO;
import com.spring.dao.ProductDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author FR
 */
@Controller(value = "AdminProductController")
public class ProductController {

    @RequestMapping("/admin/productlist")
    public ModelAndView ProductList() {

        return new ModelAndView("admin/productlist", "product", new ProductDAO().GetData());
    }

    @RequestMapping("/admin/createproduct")
    public ModelAndView CreateProduct() {
        return new ModelAndView("admin/createproduct");
    }
    
    @RequestMapping("/admin/product/selectbrand")
    public ModelAndView SelectBrand() {

        return new ModelAndView("admin/selectbrand", "brand", new BrandDAO().GetData());
    }

}
