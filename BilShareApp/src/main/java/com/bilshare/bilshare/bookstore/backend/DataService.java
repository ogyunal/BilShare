package com.bilshare.bilshare.bookstore.backend;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import com.bilshare.bilshare.bookstore.backend.data.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bilshare.bilshare.bookstore.backend.data.Category;
import com.bilshare.bilshare.bookstore.backend.data.Product;
import com.bilshare.bilshare.bookstore.backend.mock.MockDataService;

/**
 * Back-end service interface for retrieving and updating product data.
 */

@Repository
public abstract class DataService implements Serializable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String sql = "SELECT id, name, price, category, type FROM products";

    public  Collection<Product> getAllProducts() {
        List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setType(Type.valueOf(resultSet.getString("type")));
                product.setCategory((Set<Category>) resultSet.getObject("category"));
                return product;
            }
        });
        return products;
    }

    public Collection<Category> getAllCategories() {
        return null;
    }

    public void updateProduct(Product p) {

    }

    public  void deleteProduct(int productId) {

    }

    public Product getProductById(int productId) {
        return null;
    }

    public void updateCategory(Category category) {

    }

    public void deleteCategory(int categoryId) {

    }

    public static DataService get() {
        return MockDataService.getInstance();
    }

}
