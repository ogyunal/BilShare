package com.bilshare.bilshare.bookstore.backend.repository;


import com.bilshare.bilshare.bookstore.backend.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
