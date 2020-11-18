package com.spring.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ClientOrderController")
public class OrderController {

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView CheckOut() {
        return new ModelAndView("client/checkout");
    }
}
