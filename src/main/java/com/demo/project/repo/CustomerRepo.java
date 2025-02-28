package com.demo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.entity.Customer;

@SuppressWarnings("rawtypes")
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
