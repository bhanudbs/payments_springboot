package com.dbs.service;

import java.util.List;

import com.dbs.beans.Msg_info;

public interface IMsgService {

	Msg_info findById(String id);

	List<Msg_info> findAll();

}