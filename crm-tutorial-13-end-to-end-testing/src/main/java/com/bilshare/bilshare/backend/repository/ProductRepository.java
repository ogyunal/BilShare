package com.bilshare.bilshare.backend.repository;

import com.bilshare.bilshare.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
