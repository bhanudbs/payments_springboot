package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.beans.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
