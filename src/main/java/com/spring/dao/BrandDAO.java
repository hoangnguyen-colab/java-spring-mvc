package com.spring.dao;

import com.spring.dbcontext.DbContext;
import com.spring.entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {

    public List<Brand> GetData() {
        Connection conn = DbContext.getConnection();
        try {
            List<Brand> list = new ArrayList<>();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM BRAND";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("BrandID");
                String name = rs.getString("BrandName");
                String url = rs.getString("BrandUrl");

                list.add(new Brand(id, name, url));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }

    public boolean InsertData(Brand brand) {
        Connection conn = DbContext.getConnection();
        try {
            String sql = "INSERT INTO dbo.Brand (id, ten, Class, Age, Sex) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, brand.getBrandID());
            statement.setString(2, brand.getBrandName());
            statement.setString(3, brand.getBrandUrl());
            statement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));

            int rs = statement.executeUpdate();
            if (rs == 1) {
                return true;
            }

        } catch (SQLException e) {
            return false;
        }
        return false;
    }
}
