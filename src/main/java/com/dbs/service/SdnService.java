package com.dbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Sdn;
import com.dbs.repo.SdnRepo;

@Service
public class SdnService implements ISdnService {

	@Autowired
	SdnRepo sr;
	
	@Override
	public List<String> getname() {
		List<Sdn> ls = sr.findAll();
		List<String> lst = new ArrayList<>();
		int len=ls.size();
		int i;
		for(i=0;i<len;i++) {
			lst.add(ls.get(i).getName());
		}
		return lst;
	}
}
