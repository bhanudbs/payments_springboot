package com.dbs.service;

import com.dbs.beans.Customer;

public interface ICustomerService {

	Customer findById(long id);

	double findBalance(long id);

}