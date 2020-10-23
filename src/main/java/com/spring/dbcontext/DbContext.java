/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hoang Nguyen
 */
public class DbContext {

    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String connString = "jdbc:sqlserver://localhost:1433;databaseName=SHOPDIENTHOAI;instance=SQLSERVER;encrypt=true;trustServerCertificate=true";
    private final String username = "root";
    private final String password = "root";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connString, username, password);

            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}
