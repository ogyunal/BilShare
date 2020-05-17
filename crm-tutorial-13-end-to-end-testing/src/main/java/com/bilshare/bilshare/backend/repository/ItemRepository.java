package com.bilshare.bilshare.backend.repository;

import com.bilshare.bilshare.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select c from Contact c " +
          "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
          "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Item> search(@Param("searchTerm") String searchTerm);
}
