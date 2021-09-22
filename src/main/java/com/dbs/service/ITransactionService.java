package com.dbs.service;

import com.dbs.beans.Transaction;

public interface ITransactionService {

	Transaction add(Transaction trans);
	
	Transaction findById(int trans);

	double findAmount(long id);

}