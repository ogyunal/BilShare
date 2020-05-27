package com.bilshare.backend.entity;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Product Class
 * @author BilShare
 * @version 1.0
 */
@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity implements Cloneable {

    // properties
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

    @Column(name = "image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    // constructors
    public Product() {
        // empty constructor
    }

    // another constructor which takes seller as a parameter and sets the seller accordingly
    public Product(String seller) {
        this.seller = seller;
    }

    // methods
    /**
     * This method gets name of a product
     * @return the name of product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method sets the productName of a product
     * @param productName is the desired name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method gets price of a product
     * @return the price of product
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method sets the price of a product
     * @param price is the desired price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method gets price type of a product
     * @return the type of the product
     */
    public String getType() {
        return type;
    }

    /**
     * This method sets the type of a product
     * @param type is the desired type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method gets the additionalInfo of a product
     * @return the additionalInfo of the product
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * This method sets the additionalInfo of a product
     * @param additionalInfo is the desired additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * This method gets the category of a product
     * @return the category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method sets the category of a product
     * @param category is the desired category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * This method gets the seller of a product
     * @return the seller of the product
     */
    public String getSeller(){
        return seller;
    }

    /**
     * This method sets the seller of a product
     * @param seller is the desired seller
     */
    public void setSeller(String seller) {
        this.seller = seller;
    }

    /**
     * This method gets the image of a product
     * @return the image of the product
     */
    public byte[] getImage(){
        return image;
    }

    /**
     * This method sets the image of a product
     * @param image is the desired image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * The toString() method
     * @return the string representation of a product
     */
    @Override
    public String toString() {
        return productName + " " + additionalInfo;
    }

}



