package com.ogyunal.ogulcan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogyunal.ogulcan.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
