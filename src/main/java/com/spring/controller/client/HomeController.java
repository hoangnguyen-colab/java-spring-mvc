package com.spring.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfClient")
public class HomeController {

    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("client/index");
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public ModelAndView help() {
        return new ModelAndView("client/help");
    }
}
