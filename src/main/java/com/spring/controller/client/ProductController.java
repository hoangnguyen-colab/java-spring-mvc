package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.ProductDAO;
import com.spring.entity.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping(value = "shop")
    public ModelAndView Shop() {
        Integer offset = 0; Integer maxResults = 10;
        ModelAndView mv = new ModelAndView("client/shop");
        
        return mv;
    }

    @RequestMapping(value = "shop/productdata", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String ProductData() {
        return new Gson().toJson(new ProductDAO().GetData());
        //return list;
    }
}
