package com.dbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Transaction;
import com.dbs.repo.TransactionRepo;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	TransactionRepo tr;
	
	@Override
	public Transaction add(Transaction trans) {
		return tr.save(trans);
	}
	@Override
	public Transaction findById(int trans) {
		return tr.findById(trans).get();
	}
	
	@Override
	public double findAmount(long id) {
		return tr.getTotalamount(id);
	}
}