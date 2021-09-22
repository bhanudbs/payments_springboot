package com.dbs.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.dbs.enums.overdraftEnum;

@Entity
public class Customer {

	@Id
	long c_id;
	String c_name;
	double balance;
	@Enumerated(EnumType.STRING)
	overdraftEnum overdraft;
	public Customer(long c_id, String c_name, double balance, overdraftEnum overdraft) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.balance = balance;
		this.overdraft = overdraft;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", balance=" + balance + ", od=" + overdraft + "]";
	}
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public overdraftEnum getOd() {
		return overdraft;
	}
	public void setOd(overdraftEnum od1) {
		this.overdraft = od1;
	}
	
	
}
