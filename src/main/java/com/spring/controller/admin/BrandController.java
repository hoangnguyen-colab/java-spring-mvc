package com.spring.controller.admin;

import com.google.gson.Gson;
import com.spring.dao.BrandDAO;
import com.spring.dao.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "AdminBrandController")
public class BrandController {

    @RequestMapping("admin/brand")
    public ModelAndView BrandHome() {

        return new ModelAndView("admin/brandhome", "brandlist", new BrandDAO().GetData());
    }

    @RequestMapping(value = "admin/brand/submitcreate", method = RequestMethod.GET)
    @ResponseBody
    public String SubmitCreate(String BrandName) {
        int result = new BrandDAO().InsertData(BrandName);
        if (result == 1) {

            return new Gson().toJson("Success");
        } else {
            return new Gson().toJson("Fail");
        }

        //return list;
    }

    @RequestMapping(value = "admin/brand/branddata", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String ProductData() {

        return new Gson().toJson(new BrandDAO().GetData());
    }
}
