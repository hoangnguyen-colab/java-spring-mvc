package com.spring.dao;

import com.spring.dbcontext.DbContext;
import com.spring.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

    public Customer GetByUsername(String username) {
        Connection conn = DbContext.getConnection();
        try {
            String query = " SELECT * FROM dbo.CUSTOMER c WHERE c.CustomerUsername=?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            Customer customer = new Customer();
            while (rs.next()) {
                customer.setCustomerID(rs.getInt("CustomerID"));
                customer.setCustomerUsername(username);
                customer.setCustomerName(rs.getString("CustomerName"));
            }

            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int Login(String username, String password) {

        Connection conn = DbContext.getConnection();
        try {
            String query = "SELECT count(c.CustomerUsername) AS 'count' FROM dbo.CUSTOMER c\n"
                    + "	WHERE c.CustomerUsername=? AND c.CustomerPassword=?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
            }

            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public int Signup(Customer model) {
        return 0;

//        Connection conn = DbContext.getConnection();
//        try {
//            String query = "SELECT count(c.CustomerUsername) AS 'count' FROM dbo.CUSTOMER c\n"
//                    + "	WHERE c.CustomerUsername=? AND c.CustomerPassword=?";
//            PreparedStatement st = conn.prepareStatement(query);
//
//
//            ResultSet rs = st.executeQuery();
//            int count = 0;
//            while (rs.next()) {
//                count = rs.getInt("count");
//            }
//
//            return count;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
    }
}
