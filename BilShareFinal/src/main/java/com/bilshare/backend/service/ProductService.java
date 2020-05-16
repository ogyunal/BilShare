package com.bilshare.backend.service;

import com.bilshare.backend.entity.Product;
import com.bilshare.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAll(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return productRepository.findAll();
        } else  {
            return  productRepository.search(filterText);
        }
    }

    public long count() {
        return productRepository.count();
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    /*public void save(Product product) {
        if (product == null) {
            LOGGER.log(Level.SEVERE,
                "Product is null.");
            return;
        }
        productRepository.save(product);
    }*/

    public void save(Product product) {
        Product newProduct = new Product(product.getSeller());
        //Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setPrice(product.getPrice());
        newProduct.setType(product.getType());
        newProduct.setAdditionalInfo(product.getAdditionalInfo());
        productRepository.save(product);
    }

    public void getStats() {
    }

}
