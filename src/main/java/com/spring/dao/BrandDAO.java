/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;

import com.spring.entity.Brand;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {

    public List<Brand> GetData(Connection conn) {
        List<Brand> list = new ArrayList<>();
        Statement st = null;
        String query = "SELECT * FROM Brand";
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("BrandID");
                String name = rs.getString("BrandName");
                String url = rs.getString("BrandUrl");

                list.add(new Brand(id, name, url));
            }

            try {
                conn.close();
            } catch (Exception e) {
            }

            return list;

        } catch (SQLException e) {
            return null;
        }
    }
}
