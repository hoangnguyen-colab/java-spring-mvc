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
        String encrypt = CommonFunction.StringToMD5(CustomerPassword);
        int result = customerdao.Login(CustomerUsername, encrypt);
        if (result == -1) {

            return new Gson().toJson(new JsonStatus(false, "Db Error"));
        } else if (result == 0) {
            return new Gson().toJson(new JsonStatus(false, "Fail"));
        } else {
            session.setAttribute("customerLogin", customerdao.GetByUsername(CustomerUsername));
            return new Gson().toJson(new JsonStatus(true, "Success"));
        }
    }
    
    @RequestMapping(value = "customer/signup", method = RequestMethod.GET)
    public @ResponseBody
    String ValidateUser(HttpSession session, Customer model) {
        model.setCustomerPassword(CommonFunction.StringToMD5(model.getCustomerPassword()));
        int result = customerdao.Signup(model);
        
        if (result == -1) {
            return new Gson().toJson(new JsonStatus(false, "Db Error"));
        } else if (result == 0) {
            return new Gson().toJson(new JsonStatus(false, "Fail"));
        } else {
            return new Gson().toJson(new JsonStatus(true, "Success"));
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session) {

        session.setAttribute("customerLogin", null);

        return new ModelAndView("client/login");
    }
}
