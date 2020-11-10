/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.admin;

import com.spring.dao.OrderDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author FR
 */
@Controller
public class OrderController {
    
    @RequestMapping("admin/orderlist")
    public ModelAndView OrderList (){
        return new ModelAndView("admin/orderlist","orderlist", new OrderDAO().GetData());
    }
}
