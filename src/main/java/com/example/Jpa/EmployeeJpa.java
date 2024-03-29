package com.example.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.ClientModel;
import com.example.model.EmployeeModel;

public interface EmployeeJpa extends CrudRepository<EmployeeModel, Integer> {

	
	@Query("from EmployeeModel where  status=1  "  )
	 
	 public List<EmployeeModel> getEmployeeList( );
}
