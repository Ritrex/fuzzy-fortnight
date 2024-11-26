package com.rart.license_demo.license_handler.model;

public class Product {
    Integer productID;
    String name;
    Double Price;
    Integer parentProductID;


    public Product(String name, Double price, Integer parentProductID) {
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
