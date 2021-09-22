package com.dbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZPaymentApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ZPaymentApplication.class, args);
//		ConfigurableApplicationContext ctxt = SpringApplication.run(ZPaymentApplication.class, args);
//		CustomerC cr = ctxt.getBean(CustomerC.class);
//		BankC br = ctxt.getBean(BankC.class);
//		MsgC mr =ctxt.getBean(MsgC.class);
//	
//		Long l = 13645221972859L;
//		Customer c = cr.findById(l);
//		System.out.println(c);
//		
//		Long l1 = 64059555180495L;
//		Customer c1 = cr.findById(l1);
//		System.out.println(c1);
//		
//		String bic = "HDFCINBBAHM";
//		Bank b = br.findById(bic);
//		System.out.println(b);
//		
//		String msg="CHQB";
//		Msg_info mi = mr.findById(msg);
//		System.out.println(mi);
	}

}
