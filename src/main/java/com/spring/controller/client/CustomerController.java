package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.CustomerDAO;
import com.spring.dao.ProductDAO;
import com.spring.entity.JsonStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerdao;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login() {

        return new ModelAndView("client/login");
    }

    @RequestMapping(value = "/customer/{username}", method = RequestMethod.GET)
    public ModelAndView CustomerDetail(@PathVariable(required = true, name = "username") String username, HttpSession session) {
        if (session.getAttribute("customerLogin") == null) {
            return new ModelAndView("client/login");
        }
        return new ModelAndView("client/customerdetail");
    }

    @RequestMapping(value = "customer/vaidate", method = RequestMethod.GET)
    public @ResponseBody
    String ValidateUser(HttpSession session, String CustomerUsername, String CustomerPassword) {

        int result = customerdao.Login(CustomerUsername, CustomerPassword);
        if (result == -1) {

            return new Gson().toJson(new JsonStatus(false, "Db Error"));
        } else if (result == 0) {
            return new Gson().toJson(new JsonStatus(false, "Fail"));
        } else {
            
            session.setAttribute("customerLogin", customerdao.GetByUsername(CustomerUsername));
            
            return new Gson().toJson(new JsonStatus(true, "Success"));
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {
        
        session.setAttribute("customerLogin", null);
        
        return new ModelAndView("client/login");
    }
}
