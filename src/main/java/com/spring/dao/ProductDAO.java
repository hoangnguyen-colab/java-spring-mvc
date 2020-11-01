package com.spring.dao;

import com.spring.dbcontext.DbContext;
import com.spring.entity.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> GetData() {
        Connection conn = DbContext.getConnection();
        try {
            List<Product> list = new ArrayList<>();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM PRODUCT";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                String desc = rs.getString("ProductDescription");
                BigDecimal price = rs.getBigDecimal("ProductPrice");
                BigDecimal promoprice = rs.getBigDecimal("PromotionPrice");
                String img = rs.getString("ProductImage");
                String url = rs.getString("ProductURL");
                int brandid = rs.getInt("BrandID");

                list.add(new Product(id, name, desc, price, promoprice, img, url, brandid));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
    
    public Product GetDataByID(int productid){
        Connection conn = DbContext.getConnection();
        try {
            List<Product> list = new ArrayList<>();
            String query = "SELECT * FROM PRODUCT WHERE PRODUCT.ProductID = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, productid);
            Product prod = new Product();
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                prod.setProductID(rs.getInt("ProductID"));
                prod.setProductName(rs.getString("ProductName"));
                prod.setProductDescription(rs.getString("ProductDescription"));
                prod.setProductPrice(rs.getBigDecimal("ProductPrice"));
                prod.setPromotionPrice(rs.getBigDecimal("PromotionPrice"));
                prod.setProductImage(rs.getString("ProductImage"));
                prod.setProductURL(rs.getString("ProductURL"));
                prod.setRating(rs.getInt("Rating"));
                prod.setViewcount(rs.getInt("Viewcount"));
                prod.setProductStock(rs.getInt("ProductStock"));
                prod.setCreatedDate(rs.getDate("CreatedDate"));
                prod.setBrandID(rs.getInt("BrandID"));
            }
            return prod;

        } catch (SQLException e) {
            return null;
        }
    }

    public List<Product> GetData(int offset, int max) {
        Connection conn = DbContext.getConnection();
        try {
            List<Product> list = new ArrayList<>();
            String query = "SELECT * FROM PRODUCT ORDER BY ProductID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, offset);
            st.setInt(2, max);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                String desc = rs.getString("ProductDescription");
                BigDecimal price = rs.getBigDecimal("ProductPrice");
                BigDecimal promoprice = rs.getBigDecimal("PromotionPrice");
                String img = rs.getString("ProductImage");
                String url = rs.getString("ProductURL");
                int brandid = rs.getInt("BrandID");

                list.add(new Product(id, name, desc, price, promoprice, img, url, brandid));
            }
            return list;

        } catch (SQLException e) {
            return null;
        }
    }
    
    public Integer Count() {
        Connection conn = DbContext.getConnection();
        try {
            String query = "SELECT COUNT(*) AS 'Count' FROM PRODUCT ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            return rs.getInt("Count");

        } catch (SQLException e) {
            return null;
        }
    }

//    ProductID INT PRIMARY KEY IDENTITY(1, 1),
//    ProductName NVARCHAR(255) NOT NULL,
//    ProductDescription NVARCHAR(MAX),--mô tả
//    ProductPrice DECIMAL(18, 0) NOT NULL,
//    PromotionPrice DECIMAL(18, 0) DEFAULT 0,
//    Rating INT CHECK (RATING >=0 AND RATING <= 5),
//    ProductImage NVARCHAR(4000) DEFAULT N'',
//    ProductStock INT DEFAULT 1,--tồn kho
//    ProductURL NVARCHAR(255),
//    Viewcount INT,
//    ProductStatus BIT,
//    CreatedDate DATETIME DEFAULT GETDATE(),
//    BrandID 
}
