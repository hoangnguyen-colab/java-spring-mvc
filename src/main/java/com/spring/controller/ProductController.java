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

    private DbContext db = new DbContext();
    
    @RequestMapping(value = "shop")
    public ModelAndView Shop() {
        ModelAndView mv = new ModelAndView("shop");
        Connection conn = db.getConnection();
        List<Brand> list = null;
        if (conn != null) {
            list = new BrandDAO().GetData(conn);
            mv.addObject("list", list);
        }
        return mv;
    }
}
