package com.spring.dao;

import com.spring.common.CommonFunction;
import com.spring.dbcontext.DbContext;
import com.spring.entity.Brand;
import java.sql.Connection;
import java.sql.Date;
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
                Date date = rs.getDate("CreatedDate");

                list.add(new Brand(id, name, url, date));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }

    public int InsertData(String name) {
        Connection conn = DbContext.getConnection();
        try {
            String sql = "INSERT INTO dbo.Brand (BrandName, BrandUrl, CreatedDate) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, CommonFunction.toSlug(name));
            statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));

            int rs = statement.executeUpdate();
            
            return rs;

        } catch (SQLException e) {
            return 0;
        }
    }
    
    
}
