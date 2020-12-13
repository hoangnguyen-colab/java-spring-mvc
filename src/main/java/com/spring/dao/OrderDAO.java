/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;

import com.spring.dbcontext.DbContext;
import com.spring.entity.Order;
import com.spring.entity.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

    public List<Order> GetData() {
        Connection conn = DbContext.getConnection();
        try {
            List<Order> list = new ArrayList<>();
            String query = "SELECT * FROM [ORDER] ORDER BY OrderID";
            PreparedStatement st = conn.prepareStatement(query);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("OrderID");
                Date orderDate = rs.getDate("OrderDate");
                BigDecimal total = rs.getBigDecimal("Total");
                String customername = rs.getString("CustomerName");
                String customerphone = rs.getString("CustomerPhone");
                String customeraddress = rs.getString("CustomerAddress");
                int orderstatus = rs.getInt("OrderStatusID");
                int customerid = rs.getInt("CustomerID");
                list.add(new Order(id, orderDate, total, customername, customerphone, customeraddress, orderstatus, customerid));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
    public List<Order> LoadOrder(int userid) {
        Connection conn = DbContext.getConnection();
        try {
            List<Order> list = new ArrayList<>();
            String query = "SELECT * FROM [ORDER] WHERE [ORDER].CustomerID = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("OrderID");
                Date orderDate = rs.getDate("OrderDate");
                BigDecimal total = rs.getBigDecimal("Total");
                String customername = rs.getString("CustomerName");
                String customerphone = rs.getString("CustomerPhone");
                String customeraddress = rs.getString("CustomerAddress");
                int orderstatus = rs.getInt("OrderStatusID");
                int customerid = rs.getInt("CustomerID");
                
                list.add(new Order(id, orderDate, total, customername, customerphone, customeraddress, orderstatus, customerid));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
}
