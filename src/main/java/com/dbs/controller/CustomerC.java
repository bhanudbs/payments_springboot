package com.dbs.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.beans.Bank;
import com.dbs.beans.Customer;
import com.dbs.beans.Msg_info;
import com.dbs.beans.Transaction;
import com.dbs.service.IBankService;
import com.dbs.service.ICustomerService;
import com.dbs.service.IMsgService;
import com.dbs.service.ISdnService;
import com.dbs.service.ITransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerC {

	@Autowired
	ICustomerService cs;
	
	@Autowired
	ITransactionService its;
	
	@Autowired
	IBankService bs;
	
	@Autowired
	ISdnService isds;
	
	@Autowired
	IMsgService ims;
	
	double customer_bal;
	boolean check;
	
	@GetMapping(value="getTransferT/{id}",produces = "text/plain")
	public ResponseEntity<String> getTransferType(@PathVariable("id") long id){
		Customer c = cs.findById(id);
		String s = c.getC_name();
		String r;
		if(s.contains("HDFC BANK")) {
			r="Bank Transfer";
		}
		else {
			r="Customer Transfer";
		}
		System.out.println(r);
		System.out.println(new ResponseEntity<String>(r,HttpStatus.OK));
		return new ResponseEntity<String>(r,HttpStatus.OK);
	}
	@GetMapping("CgetDetails/{id}")
	public ResponseEntity<Customer> getCust(@PathVariable("id") long id)
	{
		Customer c = cs.findById(id);
		customer_bal=c.getBalance();
		check = c.getOd().equals("Yes");
		System.out.println(new ResponseEntity<>(c,HttpStatus.OK));
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@GetMapping("BgetDetails/{id}")
	public ResponseEntity<Bank> getBank(@PathVariable("id") String id)
	{
		Bank b = bs.findById(id);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("MgetDetails")
	public ResponseEntity<List<Msg_info>> getMsgs()
	{
		List<Msg_info> m = ims.findAll();
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	
	//27225043545104
	@GetMapping("amount/{id}")
	public ResponseEntity<Double> getClearAmount(@PathVariable("id") long id)
	{
		double balance = cs.findBalance(id);
		double totalAmountTransaction = its.findAmount(id);
		double clearBalance = balance-totalAmountTransaction;
		return new ResponseEntity<>(clearBalance,HttpStatus.OK);
		
	}
	
	@GetMapping(value="sdnlist/{sdnname}")
	public int getSDNlist(@PathVariable("sdnname") String n)
	{
		List<String> names = isds.getname();
		int i,l=names.size(),flag=0;
		String s2=n;
		s2 = s2.replaceAll("[^a-zA-Z0-9 ]", "");
		s2=s2.toLowerCase();
		String[] arrOfStr = s2.split(" ");
		Arrays.sort(arrOfStr);
		StringBuffer sb1 = new StringBuffer();
	    for(i = 0; i < arrOfStr.length; i++)
	       sb1.append(arrOfStr[i]);
	    String str1 = sb1.toString();
	    
		for(int j=0;j<l;j++)
		{
			String s1=names.get(j);
			s1 = s1.replaceAll("[^a-zA-Z0-9 ]", "");
			s1=s1.toLowerCase();
			String[] arrOfStr1 = s1.split(" ");
			Arrays.sort(arrOfStr1);
			StringBuffer sb = new StringBuffer();
		    for(i = 0; i < arrOfStr1.length; i++)
		       sb.append(arrOfStr1[i]);
		    String str = sb.toString();
		    if(str.equals(str1))
		    	flag=1;
		    
		    //System.out.println(str);
		}
		return flag;
			
	}
	
	@PostMapping(value="transaction")
	public ResponseEntity<Transaction> AddTrans(@RequestBody Transaction transaction)
	{
		int c=getSDNlist(transaction.getReceiver_name());
		System.out.println(transaction.getReceiver_name()+" "+c);
		if(c>0)
		{
			transaction.setTransaction_status("FAILED(Sanctioned Name)");
			//return new ResponseEntity<String>("Sanctioned Name",HttpStatus.OK);
		}
		else if(customer_bal<transaction.getAmount())
		{
			if(!check)
			{
				transaction.setTransaction_status("FAILED(Insufficient Funds)");
				//return new ResponseEntity<String>("Insufficient Funds",HttpStatus.OK);
			}
		}
//		69652133523248
//		45002608912874
//		42895235807723
//		if(transaction.getSender_id()==69652133523248L || transaction.getSender_id()==45002608912874L || transaction.getSender_id()==42895235807723L )
//		{
//			if(!(transaction.getReciever_id()==69652133523248L || transaction.getReciever_id()==45002608912874L || transaction.getReciever_id()==42895235807723L))
//			{
//				transaction.setTrans_status("FAILED(Transfer Denied from Bank to Customer)");
//				//return new ResponseEntity<String>("Transfer Denied to Customer",HttpStatus.OK);
//			}
//		}
//		if(!(transaction.getSender_id()==69652133523248L || transaction.getSender_id()==45002608912874L || transaction.getSender_id()==42895235807723L ))
//		{
//			if(transaction.getReciever_id()==69652133523248L || transaction.getReciever_id()==45002608912874L || transaction.getReciever_id()==42895235807723L)
//			{
//				transaction.setTrans_status("FAILED(Transfer Denied from Customer to Bank)");
//				//return new ResponseEntity<>("Transfer Denied to Bank",HttpStatus.OK);
//			}
//		}
		LocalDateTime now = LocalDateTime.now();  
		transaction.setTimestamp(now);
		System.out.println(transaction);
		its.add(transaction);
		return new ResponseEntity<>(transaction,HttpStatus.OK);
	}
	
	
}
