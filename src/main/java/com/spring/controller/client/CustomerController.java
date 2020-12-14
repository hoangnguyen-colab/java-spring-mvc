package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.common.CommonFunction;
import com.spring.dao.CustomerDAO;
import com.spring.dao.OrderDAO;
import com.spring.entity.Customer;
import com.spring.entity.JsonStatus;
import com.spring.entity.Order;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerdao;

    @Autowired
    private OrderDAO orderdao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login() {

        return new ModelAndView("client/login");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView CustomerDetail(HttpSession session) {
        if (session.getAttribute("customerLogin") == null) {
            return new ModelAndView("client/login");
        }
        Customer UID = (Customer) session.getAttribute("customerLogin");
        List<Order> orderlist = orderdao.LoadOrder(UID.getCustomerID());

        return new ModelAndView("client/customerdetail", "orderlist", orderlist);
    }

    @RequestMapping(value = "customer/vaidate", method = RequestMethod.GET)
    public @ResponseBody
    String ValidateUser(HttpSession session, String CustomerUsername, String CustomerPassword) {
        int result = customerdao.Login(CustomerUsername, CustomerPassword);
        switch (result) {
            case -1:
                return new Gson().toJson(new JsonStatus(false, "Db Error"));
            case 0:
                return new Gson().toJson(new JsonStatus(false, "Fail"));
            default:
                return new Gson().toJson(new JsonStatus(true, "Success"));
        }
    }

    @RequestMapping(value = "customer/signup", method = RequestMethod.GET)
    public @ResponseBody
    String SignUpUser(HttpSession session, Customer model) {
        int result = customerdao.Signup(model);

        switch (result) {
            case -1:
                return new Gson().toJson(new JsonStatus(false, "Db Error"));
            case -2:
                return new Gson().toJson(new JsonStatus(false, "Username already taken"));
            case 0:
                return new Gson().toJson(new JsonStatus(false, "Fail"));
            default:
                return new Gson().toJson(new JsonStatus(true, "Success"));
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {

        session.setAttribute("customerLogin", null);

        return new ModelAndView("client/login");
    }
}
