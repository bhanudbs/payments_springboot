package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Bank;
import com.dbs.repo.BankRepo;

@Service
public class BankService implements IBankService {

	@Autowired
	BankRepo br;
	
	@Override
	public Bank findById(String id) {
		Optional<Bank> ob = br.findById(id);
		return ob.get();
		
	}
}
