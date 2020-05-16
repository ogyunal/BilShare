package com.bilshare.backend.repository;

import com.bilshare.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p " +
            "where lower(p.productName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(p.additionalInfo) like lower(concat('%', :searchTerm, '%'))")
    List<Product> search(@Param("searchTerm") String searchTerm);


    @Query("select p from Product p " +
            "where lower(p.seller) like lower(concat('%', :sellerName, '%'))  ")
    List <Product> findBySeller(@Param("sellerName") String sellerName);

    @Query("select p from Product p " +
            "where lower(p.seller) like lower(concat('%', :sellerName, '%'))  " +
            "and lower(p.productName) like lower(concat('%', :searchTerm, '%')) ")
    List <Product> findBySellerSearch(@Param("sellerName") String sellerName,@Param ("searchTerm") String searchTERM);
}
