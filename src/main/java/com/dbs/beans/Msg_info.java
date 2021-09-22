package com.dbs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Msg_info {

	@Id
	String msg;
	String instruction;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Msg_info(String msg, String instruction) {
		super();
		this.msg = msg;
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Msg_info [msg=" + msg + ", instruction=" + instruction + "]";
	}
	public Msg_info() {
		super();
		// TODO Auto-generated constructor stub
	}
}
