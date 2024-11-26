package com.rart.license_demo.license_handler.model;

public class Agreement {
    private Integer agreementID;
    private String name;
    private String signedBy;
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
