
package com.spring.controller.client;

import com.spring.dao.ProductDAO;
import com.spring.entity.CartItem;
import com.spring.entity.CartSession;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    
    @RequestMapping(value = "/cart", method =  RequestMethod.GET)
    public ModelAndView Cart(HttpSession session){
        List<CartItem> list = null;
        session.setAttribute("cartlist", list);
        
        return new ModelAndView("client/cart");
    }
}
