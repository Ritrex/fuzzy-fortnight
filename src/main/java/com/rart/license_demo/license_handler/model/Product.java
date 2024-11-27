package com.rart.license_demo.license_handler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Product {

    @JsonProperty("productid")
    private Integer productID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double Price;

    @JsonProperty("parentid")
    private Integer parentProductID;

    private Date startDate;

    private Date endDate;

    public Product(Integer productID, String name, Double price, Integer parentProductID, Date endDate, Date startDate) {
        this.productID = productID;
        this.name = name;
        Price = price;
        this.parentProductID = parentProductID;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public Product(String name, Double price, Integer parentProductID, Date startDate, Date endDate ){
        this.name = name;
        Price = price;
        this.parentProductID = parentProductID;
    }

    public Product(Integer productID, String name, Double price, Integer parentProductID) {
        this.productID = productID;
        this.name = name;
        Price = price;
        this.parentProductID = parentProductID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getParentProductID() {
        return parentProductID;
    }

    public void setParentProductID(Integer parentProductID) {
        this.parentProductID = parentProductID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
               "productID=" + productID +
               ", name='" + name + '\'' +
               ", Price=" + Price +
               ", parentProductID=" + parentProductID +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }

    public String toJSON() {
        return "{" +
                "productID:" + productID +
                ", name:\"" + name + '\"' +
                ", Price:" + Price +
                ", parentProductID:" + parentProductID +
                '}';
    }
}
