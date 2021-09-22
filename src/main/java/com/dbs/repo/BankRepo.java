package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.beans.Bank;

public interface BankRepo extends JpaRepository<Bank, String> {

}
