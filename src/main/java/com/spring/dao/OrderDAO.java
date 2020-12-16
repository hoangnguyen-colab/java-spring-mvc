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
            String query = "SELECT * FROM [ORDER] \n" +
                            "JOIN ORDERSTATUS ON [ORDER].OrderStatusID = ORDERSTATUS.StatusID\n" +
                            "WHERE [ORDER].CustomerID = ?";
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
                String statusname = rs.getString("StatusName");
                
                list.add(new Order(id, orderDate, total, customername, customerphone, customeraddress, orderstatus, customerid, statusname));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
    
    public Order LoadOrderDetail(int orderid){
        Connection conn = DbContext.getConnection();
        try {
            Order order = new Order();
            String query = "SELECT [ORDER].OrderID, \n" +
                            "[ORDER].OrderDate, \n" +
                            "[ORDER].Total, \n" +
                            "[ORDER].CustomerName, \n" +
                            "[ORDER].CustomerAddress, \n" +
                            "[ORDER].CustomerPhone,\n" +
                            "[ORDER].OrderStatusID,\n" +
                            "ORDERSTATUS.StatusName FROM [ORDER]\n" +
                            "JOIN ORDERSTATUS ON [ORDER].OrderStatusID = ORDERSTATUS.StatusID\n" +
                            "WHERE [ORDER].OrderID = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, orderid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                order.setOrderID(rs.getInt("OrderID"));
                order.setOrderDate(rs.getDate("OrderDate"));
                order.setTotal(rs.getBigDecimal("Total"));
                order.setCustomerName(rs.getString("CustomerName"));
                order.setCustomerPhone(rs.getString("CustomerPhone"));
                order.setCustomerAddress(rs.getString("CustomerAddress"));
                order.setOrderStatusID(rs.getInt("OrderStatusID"));
                order.setStatusName(rs.getString("StatusName"));
                
                break;
            }
            return order;

        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Product> LoadOrderProduct(int orderid) {
        Connection conn = DbContext.getConnection();
        try {
            List<Product> list = new ArrayList<>();
            String query = "SELECT PRODUCT.ProductID, PRODUCT.ProductImage, PRODUCT.ProductName, PRODUCT.ProductPrice, ORDERDETAIL.Quantity\n" +
                            "FROM [ORDER] \n" +
                            "JOIN ORDERDETAIL ON [ORDER].OrderID = ORDERDETAIL.OrderID\n" +
                            "JOIN ORDERSTATUS ON [ORDER].OrderStatusID = ORDERSTATUS.StatusID\n" +
                            "JOIN PRODUCT ON ORDERDETAIL.ProductID = PRODUCT.ProductID\n" +
                            "WHERE ORDERDETAIL.OrderID = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, orderid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String image = rs.getString("ProductImage");
                String name = rs.getString("ProductName");
                BigDecimal price = rs.getBigDecimal("ProductPrice");
                int stock = rs.getInt("Quantity");
                
                list.add(new Product(id, name, price, image, stock));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
}
