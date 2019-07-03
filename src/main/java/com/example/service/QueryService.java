package com.example.service;

import java.text.ParseException;
import java.util.List;

import com.example.bean.QueryBean;
import com.example.model.ClientModel;
import com.example.model.EmployeeModel;
import com.example.model.QueryModel;

public interface QueryService {
	
	
	
	
	public void saveQuery(QueryBean queryBean)  throws ParseException;
	
	public List<QueryModel> getQueryReport(String fromDate,String toDate) throws ParseException;
	
	public List<ClientModel> getClientList();
	
	
	public void addClient(String clientName);
	 
	public List<EmployeeModel>getEmployeeList();
	public void addEmployee(String employeeName,String employeeMail,String mailType);
		

}
