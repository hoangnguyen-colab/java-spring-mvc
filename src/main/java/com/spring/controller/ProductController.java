package com.spring.controller;

import com.spring.dao.BrandDAO;
import com.spring.dbcontext.DbContext;
import com.spring.entity.Brand;
import java.sql.Connection;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping(value = "shop")
    public ModelAndView Shop() {
        return new ModelAndView("shop");
    }
}
