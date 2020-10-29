
package com.spring.controller.admin;

import com.spring.dao.BrandDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "AdminBrandController")
public class BrandController {
    
    @RequestMapping("admin/brand")
    public ModelAndView BrandHome(){
        
        return new ModelAndView("admin/brandhome", "brandlist", new BrandDAO().GetData());
    }
}
