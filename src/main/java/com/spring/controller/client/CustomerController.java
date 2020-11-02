package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "customer/vaidate", method = RequestMethod.GET)
    public @ResponseBody
    String ValidateUser(String CustomerUsername) {

        return new Gson().toJson(CustomerUsername);
        //return list;
    }
}
