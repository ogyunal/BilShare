package com.bilshare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bilshare.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u " +
            "where lower(u.username) like lower(concat('%', :username, '%'))  ")
    User findByUsername(String username);
    @Query("select u from User u " +
            "where lower(u.username) like :username " +
            "and lower(u.password) like :password ")
    User findByLogin(String username,String password);
}