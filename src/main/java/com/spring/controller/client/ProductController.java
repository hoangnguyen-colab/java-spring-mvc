package com.spring.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping(value = "shop")
    public ModelAndView Shop() {
        return new ModelAndView("client/shop");
    }
}
