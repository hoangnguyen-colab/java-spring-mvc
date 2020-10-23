
package com.spring.controller;

import com.spring.dbcontext.DbContext;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private DbContext db = new DbContext();

    @RequestMapping({"/", "/trang-chu"})
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/help")
    public ModelAndView help(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("help");
    }
}
