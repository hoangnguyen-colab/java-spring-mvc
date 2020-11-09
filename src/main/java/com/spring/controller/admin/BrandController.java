package com.spring.controller.admin;

import com.google.gson.Gson;
import com.spring.dao.BrandDAO;
import com.spring.dao.ProductDAO;
import com.spring.entity.Brand;
import com.spring.entity.JsonStatus;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "admin/brand/submitdelete", method = RequestMethod.GET)
    @ResponseBody
    public String SubmitDelete(int id) {
        boolean result = new BrandDAO().DeleteData(id);
        if (result == true) {

            return new Gson().toJson(new JsonStatus(true, "Success"));
        } else {
            return new Gson().toJson(new JsonStatus(false, "Fail"));
        }

        //return list;
    }

    @RequestMapping(value = "admin/brand/submitedit", method = RequestMethod.GET)
    @ResponseBody
    public String SubmitEdit(int id, String BrandName) {
        int result = new BrandDAO().EditData(id, BrandName);
        if (result == 0) {
            return new Gson().toJson(new JsonStatus(false, "Edit Fail"));
        } else if (result == -1) {
            return new Gson().toJson(new JsonStatus(false, "DB error"));
        } else {
            return new Gson().toJson(new JsonStatus(true, "Success"));
        }
        //return list;
    }

    @RequestMapping(value = "admin/brand/branddata", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String ProductData() {

        return new Gson().toJson(new BrandDAO().GetData());
    }
    
    
    
}
