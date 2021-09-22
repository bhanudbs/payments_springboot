package com.dbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Msg_info;
import com.dbs.repo.MsgRep;

@Service
public class MsgService implements IMsgService {

	@Autowired
	MsgRep mr;
	
	@Override
	public Msg_info findById(String id) {
		Optional<Msg_info> mo =mr.findById(id);
		return mo.get();
	}
	
	@Override
	public List<Msg_info> findAll() {
		List<Msg_info> mo = mr.findAll();
		return mo;
	}
}
