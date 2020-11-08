package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

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
    String ValidateUser(String CustomerUsername) {

        return new Gson().toJson(CustomerUsername);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {
        
        session.setAttribute("customerLogin", null);
        
        return new ModelAndView("client/login");
    }
}
