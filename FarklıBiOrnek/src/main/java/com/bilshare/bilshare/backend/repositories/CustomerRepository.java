package com.bilshare.bilshare.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilshare.bilshare.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
