package com.rart.license_demo.license_handler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agreement {

    @JsonProperty("agreement_id")
    private Integer agreementID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("signed_by")
    private String signedBy;

    @JsonProperty("product_id")
    private Integer productID;

    public Agreement(Integer agreementID, String name, String signedBy, Integer productID) {
        this.agreementID = agreementID;
        this.name = name;
        this.signedBy = signedBy;
        this.productID = productID;
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

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "agreementID=" + agreementID +
                ", name='" + name + '\'' +
                ", signedBy='" + signedBy + '\'' +
                ", productID=" + productID +
                '}';
    }

    public String toJSON() {
        return "{" +
                "agreementID:" + agreementID +
                ", name:'" + name + '\'' +
                ", signedBy:\"" + signedBy + '\"' +
                ", productID:" + productID +
                '}';
    }
}
