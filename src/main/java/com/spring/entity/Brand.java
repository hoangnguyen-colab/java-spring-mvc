/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

/**
 *
 * @author Hoang Nguyen
 */
public class Brand {

    private int BrandID;
    private String BrandName;
    private String BrandUrl;

    public Brand() {
    }

    public Brand(int BrandID, String BrandName, String BrandUrl) {
        this.BrandID = BrandID;
        this.BrandName = BrandName;
        this.BrandUrl = BrandUrl;
    }

    public int getBrandID() {
        return BrandID;
    }

    public void setBrandID(int BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getBrandUrl() {
        return BrandUrl;
    }

    public void setBrandUrl(String BrandUrl) {
        this.BrandUrl = BrandUrl;
    }

}
