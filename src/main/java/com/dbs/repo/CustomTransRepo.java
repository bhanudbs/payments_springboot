package com.dbs.repo;

import org.springframework.data.jdbc.repository.query.*;
import org.springframework.data.repository.query.Param;

public interface CustomTransRepo {

	@org.springframework.data.jpa.repository.Query(nativeQuery = true, value="SELECT SUM(amount) as TotalA from transaction WHERE s_id =?1")
	public double getTotalamount(@Param("s_id") long s_id);
}
