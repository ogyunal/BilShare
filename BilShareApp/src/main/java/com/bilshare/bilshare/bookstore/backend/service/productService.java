/*
package com.bilshare.bilshare.bookstore.backend.service;

import com.bilshare.bilshare.bookstore.backend.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

public class productService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product>

    findAll() {
        return jdbcTemplate.query(
                "SELECT ID, PRODUCT_NAME, PRICE, CATEGORY, TYPE FROM PRODUCTS",
                (rs, rowNum) -> new Product(rs.getLong("ID"),
                        rs.getString("PRODUCT_NAME"), rs.getBigDecimal("PRICE"), rs.getString("CATEGORY"), rs.getString("TYPE")));
    }

    public void update(Product product) {
        jdbcTemplate.update(
                "UPDATE PRODUCTS SET ID=?, PRODUCT_NAME=?, PRICE=?, CATEGORY=?, TYPE=?",
                product.getId(), product.getProductName(), product.getPrice(), product.getCategory(), product.getType());
    }

}
*/
