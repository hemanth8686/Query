package com.example.Jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.QueryModel;

public interface QueryJpa extends CrudRepository<QueryModel, Integer> {
	
	
	
	 @Query("from QueryModel where createdDate>=:fromDate and createdDate>=:toDate  "  )
	 
	 public List<QueryModel> getQueryReport(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate );

}
