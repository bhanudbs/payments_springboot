package com.dbs.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int transaction_id;
	@ManyToOne()
	@Transient
	Customer customer;
	@JoinColumn(name="s_id", referencedColumnName = "c_id")
	long s_id;
	long r_id;
	double amount;
	@ManyToOne()
	@Transient
	Bank bank;
	@JoinColumn(name = "b_id", referencedColumnName = "bic")
	String b_id;
	LocalDateTime timestamp;
	String transaction_status;
	@ManyToOne()
	@Transient
	Msg_info msg_info;
	@JoinColumn(name = "msg", referencedColumnName = "msg")
	String msg;
	String receiver_name;
	
	
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public long getS_id() {
		return s_id;
	}
	public void setS_id(long s_id) {
		this.s_id = s_id;
	}
	public long getR_id() {
		return r_id;
	}
	public void setR_id(long r_id) {
		this.r_id = r_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getTransaction_status() {
		return transaction_status;
	}
	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transaction_id, long s_id, long r_id, double amount,
			String b_id, LocalDateTime timestamp, String transaction_status,  String msg, String receiver_name) {
		super();
		this.transaction_id = transaction_id;
		this.s_id = s_id;
		this.r_id = r_id;
		this.amount = amount;
		this.b_id = b_id;
		this.timestamp = timestamp;
		this.transaction_status = transaction_status;
		this.msg = msg;
		this.receiver_name = receiver_name;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", s_id=" + s_id + ", r_id=" + r_id + ", amount="
				+ amount + ", b_id=" + b_id + ", timestamp=" + timestamp + ", transaction_status=" + transaction_status
				+ ", msg=" + msg + ", receiver_name=" + receiver_name + "]";
	}
	
	
}
