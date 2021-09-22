package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Customer;
import com.dbs.repo.CustomerRepo;

/*
	@Component	generic stereotype for any Spring-managed component
	@Repository	stereotype for persistence layer
	@Service	stereotype for service layer
	@Controller	stereotype for presentation layer (spring-mvc)
 */
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepo cr;
	@Override
	public Customer findById(long id) {
		Optional<Customer> oc = cr.findById(id);
		return oc.get();
	}
	
	@Override
	public double findBalance(long id) {
		Optional<Customer> oc =cr.findById(id);
		Customer c = oc.get();
		return c.getBalance();
	}
}
