package com.bilshare.backend.entity;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity implements Cloneable {


    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
    @Column(name="product_name")
    private String productName;

    @NotNull(message = "You have to specify a price")
    @Column
    @Min(0)
    private double price;


    @NotNull(message = "You have to specify the Category")
    @Column
    private String category;

    @Column(name="additional_info")
    private String additionalInfo;

    @NotNull(message = "You have to specify the type of product")
    @Column
    private String type;


    @NotNull(message = "User not found")
    @Column(name = "seller")
    private String seller;

    //@NotNull(message = "Image not found")
    @Column(name = "image")
    private String image;

    //@Email
    //@NotNull
    //@NotEmpty
    //private String email = "";

    public Product() {
    }

    public Product(String seller){
        this.seller = seller;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*public String getEmail() {
        return email;
    }*/

    /*public void setEmail(String email) {
        this.email = email;
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSeller(){
        return seller;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    @Override
    public String toString() {
        return productName + " " + additionalInfo;
    }

}



