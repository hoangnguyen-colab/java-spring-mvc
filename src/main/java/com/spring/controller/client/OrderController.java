package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.OrderDAO;
import com.spring.dao.ProductDAO;
import com.spring.entity.CartItem;
import com.spring.entity.JsonStatus;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ClientOrderController")
public class OrderController {

    @Autowired
    private OrderDAO orderdao;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView CheckOut(HttpServletResponse res, HttpSession session) throws IOException {
        if (session.getAttribute("cartlist") == null) {

            String url = "/cart";

            res.sendRedirect(url);
        }
        return new ModelAndView("client/checkout");
    }

    @RequestMapping(value = "/orderdetail/{orderid}", method = RequestMethod.GET)
    public ModelAndView OrderDetail(@PathVariable(required = true, name = "orderid") int orderid) {
        ModelAndView mnv = new ModelAndView("client/orderdetail");
        mnv.addObject("customerdetail", orderdao.LoadOrderDetail(orderid));
        mnv.addObject("productlist", orderdao.LoadOrderProduct(orderid));

        return mnv;
    }
    
    @RequestMapping(value = "/submitcheckout", method = RequestMethod.GET)
    public @ResponseBody
    String Checkout(HttpSession session) {
        try {
            return new Gson().toJson(new JsonStatus(true, "Success"));
        } catch (Exception e) {
            return new Gson().toJson(new JsonStatus(false, e.getMessage()));
        }
    }
}
