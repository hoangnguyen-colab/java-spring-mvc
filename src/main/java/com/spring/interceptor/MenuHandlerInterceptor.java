package com.spring.interceptor;

import com.spring.dao.BrandDAO;
import com.spring.dbcontext.DbContext;
import com.spring.entity.Brand;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MenuHandlerInterceptor implements HandlerInterceptor {

    private DbContext db = new DbContext();

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
        Connection conn = db.getConnection();
        if (conn != null) {
            hsr.setAttribute("list", new BrandDAO().GetData(conn));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {

    }

}
