package com.bilshare.backend.repository;

import com.bilshare.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    List <Product> findBySellerSearch(@Param("sellerName") String sellerName,@Param ("searchTerm") String searchTerm);

    @Transactional
    @Modifying
    @Query ( "update Product p " +
            "set p.productName = :newName " +
            "where lower(p.id) like lower(concat('%', :id, '%')) ")
    void setName ( @Param("id") Long id,@Param("newName") String newName);

    @Transactional
    @Modifying
    @Query ( "update Product p " +
            "set p.price = :newPrice " +
            "where lower(p.id) like lower(concat('%', :id, '%')) ")
    void setPrice ( @Param("id") Long id,@Param("newPrice") Double newPrice);

    @Transactional
    @Modifying
    @Query ( "update Product p " +
            "set p.additionalInfo = :newInfo " +
            "where lower(p.id) like lower(concat('%', :id, '%')) ")
    void setInfo ( @Param("id") Long id,@Param("newInfo") String newInfo);

    @Transactional
    @Modifying
    @Query ( "update Product p " +
            "set p.type = :newType " +
            "where lower(p.id) like lower(concat('%', :id, '%')) ")
    void setType( @Param("id") Long id,@Param("newType") String newType);

    @Transactional
    @Modifying
    @Query ( "update Product p " +
            "set p.category = :newCategory " +
            "where lower(p.id) like lower(concat('%', :id, '%')) ")
    void setCategory( @Param("id") Long id,@Param("newCategory") String newCategory);
}
