package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.beans.Msg_info;

public interface MsgRep extends JpaRepository<Msg_info, String> {

}
