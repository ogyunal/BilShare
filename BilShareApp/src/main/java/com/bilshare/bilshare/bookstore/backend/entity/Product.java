package com.bilshare.bilshare.bookstore.backend.entity;


import com.berkturkcapar.bilshare.backend.data.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity {

    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
    @Column(name="product_name")
    private String productName;

    @NotNull(message = "You have to specify a price")
    @Column
    @Min(0)
    private double price;

    //@Enumerated(EnumType.STRING)
    //@OneToMany(mappedBy = "category")
    @NotNull(message = "You have to specify the Category")
    @Column
    private String category;

    @Column(name="additional_info")
    private String additionalInfo;

    @NotNull(message = "You have to specify the type of product")
    @Column
    private String type;
    //private Type type;

    @NotNull(message = "user not found")
    @Column
    //@OneToOne
    private String seller;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSeller(){
        return seller;
    }
}
