package com.rart.license_demo.license_handler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rart.license_demo.license_handler.controller.AgreementController;

import java.util.List;

public class AgreementWithProducts {

    @JsonProperty("agreement_id")
    private Integer agreementID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("signed_by")
    private String signedBy;

    @JsonProperty("product_id")
    private Integer productID;

    @JsonProperty("products")
    private List<Product> products;

    public AgreementWithProducts(Integer agreementID, List<Product> products, Integer productID, String signedBy, String name) {
        this.agreementID = agreementID;
        this.products = products;
        this.productID = productID;
        this.signedBy = signedBy;
        this.name = name;
    }

    public AgreementWithProducts(Agreement a, List<Product> lp){
        this.agreementID = a.getAgreementID();
        this.products = lp;
        this.productID = a.getProductID();
        this.signedBy = a.getSignedBy();
        this.name = a.getName();
    }

    public Integer getAgreementID() {
        return agreementID;
    }

    public void setAgreementID(Integer agreementID) {
        this.agreementID = agreementID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }
}
