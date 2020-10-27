/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.entity;
import java.sql.Date;
/**
 *
 * @author FR
 */
public class Customer {

    private int CustomerID;
    private String CustomerName;
    private String CustomerPassword;
    private String CustomeEmail;
    private String CustomeName;
    private String CustomePhone;
    private String CustomerAddress;
    private Date CreatedDate;
    
    public int getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerPassword() {
        return CustomerPassword;
    }

    public String getCustomeEmail() {
        return CustomeEmail;
    }

    public String getCustomeName() {
        return CustomeName;
    }

    public String getCustomePhone() {
        return CustomePhone;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setCustomerPassword(String CustomerPassword) {
        this.CustomerPassword = CustomerPassword;
    }

    public void setCustomeEmail(String CustomeEmail) {
        this.CustomeEmail = CustomeEmail;
    }

    public void setCustomeName(String CustomeName) {
        this.CustomeName = CustomeName;
    }

    public void setCustomePhone(String CustomePhone) {
        this.CustomePhone = CustomePhone;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    
    
    
}
