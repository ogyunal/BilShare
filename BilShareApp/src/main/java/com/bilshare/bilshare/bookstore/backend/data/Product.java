package com.bilshare.bilshare.bookstore.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class Product implements Serializable {

    @NotNull
    private int id = -1;
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
    private String productName = "";
    @Min(0)
    private BigDecimal price = BigDecimal.ZERO;
    private Set<Category> category;
    //@Min(value = 0, message = "Can't have negative amount in stock")
    //private int stockCount = 0;
    private Type type = Type.BOOKS;

    public Product() {

    }

    public Product (BigDecimal price, String productName, int id) {
        this.price = price;
        this.productName = productName;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
       /* List<Product> products = jdbcTemplate.query("SELECT name FROM products", new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setProductName(resultSet.getString("name"));
                return product;
            }
        });*/
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    //public int getStockCount() {
        //return stockCount;
    //}

    //public void setStockCount(int stockCount) {
        //this.stockCount = stockCount;
    //}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isNewProduct() {
        return getId() == -1;
    }

    /*
     * Vaadin DataProviders rely on properly implemented equals and hashcode
     * methods.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || id == -1) {
            return false;
        }
        if (obj instanceof Product) {
            return id == ((Product) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (id == -1) {
            return super.hashCode();
        }

        return Objects.hash(id);
    }
}
