package com.example.daoImpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Jpa.ClientJpa;
import com.example.Jpa.EmployeeJpa;
import com.example.Jpa.QueryJpa;
import com.example.bean.QueryBean;
import com.example.dao.QueryDao;
import com.example.model.ClientModel;
import com.example.model.EmployeeModel;
import com.example.model.QueryModel;

@Repository
public class QueryDaoImpl implements QueryDao {
	
	@Autowired
	private QueryJpa queryJpa;
	
	
	@Autowired
	private ClientJpa clientJpa;
	
	
	@Autowired
	private EmployeeJpa employeeJpa;
	
	
	
	static String format = "";

	public static String getCurrentDate() {

		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		format = sdf.format(cal);
		System.out.println(format);
		return format;

	}

	public static String getDatelog() {
		String dat = "";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = new Date();
		dat = dateFormat.format(date);

		return dat;
	}
	
	
	public void saveQuery(QueryBean queryBean) throws ParseException {
		QueryModel model=new QueryModel();
		System.out.println(queryBean.getRaisedDate()+"tesing dao");
		String raisedDate = queryBean.getRaisedDate();
		String completedDate = queryBean.getCompletedDate();
	
		   Date raisedDateForModel=new SimpleDateFormat("yyyy-MM-dd").parse(raisedDate); 
		   System.out.println(raisedDateForModel+"raisedDateForModelraisedDateForModel");
		   Date   completedDateForModel=new SimpleDateFormat("yyyy-MM-dd").parse(completedDate);  
		model.setClient(queryBean.getClient());
		model.setRaisedDate(raisedDateForModel);
		model.setQuery(queryBean.getQuery());
		model.setRaisedBy(queryBean.getRaisedBy());
		model.setRaisedThrough((queryBean.getRaisedThrough()));
		model.setClosedBy(queryBean.getCompletedBy());
		model.setClosedDate(completedDateForModel);
		model.setCreatedDate(new Timestamp(new Date().getTime()));
		queryJpa.save(model);
	}

	@Override
	public List<QueryModel> getQueryReport(String fromDate, String toDate) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println(fromDate+"fromDatefromDate"+toDate+"toDatetoDate");
		  Date fromDateQuery=new SimpleDateFormat("yyyy-MM-dd").parse(fromDate); 
		  Date toDateQuery=new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		List<QueryModel> queryReport = queryJpa.getQueryReport(fromDateQuery, toDateQuery);
		for (QueryModel queryModel : queryReport) {
			System.out.println(queryModel.getQuery()+"gotoQueryReportgotoQueryReportgotoQueryReport");
			
		}
		return queryReport;
	}

	@Override
	public List<ClientModel> getClientList() {
		List<ClientModel> clientList = clientJpa.getClientList();
		return clientList;
	}

	@Override
	public void addClient(String clientName) {
		ClientModel clientModel=new ClientModel();
		clientModel.setClientName("clientName");
		clientModel.setStatus(1);
		clientJpa.save(clientModel);
		
	}

	@Override
	public List<EmployeeModel> getEmployeeList() {
		List<EmployeeModel> employeeList = employeeJpa.getEmployeeList();
		return employeeList;
	}

	@Override
	public void addEmployee(String employeeName, String employeeMail, String mailType) {
		EmployeeModel employeeModel=new EmployeeModel();
		employeeModel.setEmployeeName(employeeName);
		employeeModel.setEmployeeMail(employeeMail);
		employeeModel.setMailType(mailType);
		employeeJpa.save(employeeModel);
	}
	
	
	

}
