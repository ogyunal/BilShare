package com.bilshare.bilshare.backend.service;

import com.bilshare.bilshare.backend.entity.Product;
import com.bilshare.bilshare.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Map<String, Integer> getStats() {
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(company ->
            stats.put(company.getName(), company.getProducts().size()));
        return stats;
    }
}
