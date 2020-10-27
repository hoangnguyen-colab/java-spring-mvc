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
public class Order {

    private int OrderID;
    private Date OrderDate;
    private float Total;
    private String CustomerName;
    private String CustomerPhone;
    private String CustomerAddress;
    private int OrderStatusID;
    private int CustomerID;
    
    public int getOrderID() {
        return OrderID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public float getTotal() {
        return Total;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public int getOrderStatusID() {
        return OrderStatusID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public void setOrderStatusID(int OrderStatusID) {
        this.OrderStatusID = OrderStatusID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    
    
}
