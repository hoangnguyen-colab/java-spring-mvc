package com.spring.controller.client;

import com.google.gson.Gson;
import com.spring.dao.ProductDAO;
import com.spring.entity.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping(value = {"shop", "shop/{page}"}, method = RequestMethod.GET)
    public ModelAndView Shop(@PathVariable(required = false, name = "page") String page, HttpServletRequest req, HttpServletResponse res) {
       int pageSize = 10;
        
        ModelAndView mv = new ModelAndView("client/shop");
        PagedListHolder<Product> productlist;
        if (page == null) {
            productlist = new PagedListHolder<>();
            List<Product> productList = new ProductDAO().GetData();
            productlist.setSource(productList);
            productlist.setPageSize(pageSize);
            req.getSession().setAttribute("productlist", productlist);
        } else if (page.equals("prev")) {
            productlist = (PagedListHolder<Product>) req.getSession().getAttribute("productlist");
            productlist.previousPage();
        } else if (page.equals("next")) {
            productlist = (PagedListHolder<Product>) req.getSession().getAttribute("productlist");
            productlist.nextPage();
        } else {
            int pageNum = Integer.parseInt(page);
            productlist = (PagedListHolder<Product>) req.getSession().getAttribute("productlist");
            productlist.setPage(pageNum - 1);
        }
        
        return mv;
    }

    @RequestMapping(value = "shop/productdata", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String ProductData() {
        return new Gson().toJson(new ProductDAO().GetData());
        //return list;
    }
}
