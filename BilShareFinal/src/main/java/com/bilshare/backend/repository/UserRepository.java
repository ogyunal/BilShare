package com.bilshare.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bilshare.backend.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}