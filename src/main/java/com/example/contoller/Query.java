package com.example.contoller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bean.QueryBean;
import com.example.model.ClientModel;
import com.example.model.EmployeeModel;
import com.example.model.QueryModel;
import com.example.service.QueryService;

@Controller
public class Query {
	
	@Autowired
	private QueryBean queryBean;
	
	@Autowired
	private QueryService queryService;
	
	@RequestMapping(value="gotoQuery")
	public ModelAndView test() {
		ModelAndView view=new ModelAndView();
		view.setViewName("QueryEntry");
		return view;
	}
	
	
	@RequestMapping(value="queryEnter")
	public ModelAndView queryEnter(@ModelAttribute(value="QueryBean") QueryBean queryBean)  throws ParseException{
		ModelAndView view=new ModelAndView();
		queryService.saveQuery(queryBean);
		view.setViewName("QueryEntry");
		return view;
		
	}
	
	@RequestMapping(value="gotoQueryReport")
	
	public String gotoQueryReport() {
		return "QueryReport";
		
	}
	
	
	@RequestMapping(value="queryReport")
	public ModelAndView queryReport(@RequestParam(value="fromDate") String fromDate,@RequestParam(value="toDate") String toDate) throws ParseException {
		ModelAndView view=new ModelAndView();
		System.out.println(fromDate+".."+toDate);
		List<QueryModel> queryReport = queryService.getQueryReport(fromDate, toDate);
		view.addObject("queryReport", queryReport);
		view.setViewName("QueryReport");
		return view;
		
	}
	
	
	
	@RequestMapping(value="gotoAddClient")
	public ModelAndView gotoAddClient() {
		ModelAndView view=new ModelAndView();
		List<ClientModel> clientList = queryService.getClientList();
		view.addObject("clientList", clientList);
		view.setViewName("AddClient");
		return view;
	}
	
	
	
	@RequestMapping(value="addClient")
	public ModelAndView addClient(@RequestParam(value="clientName") String clientName) {
		ModelAndView view=new ModelAndView();
		List<ClientModel> clientList = queryService.getClientList();
		view.addObject("clientList", clientList);
		view.setViewName("AddClient");
		
		return view;
	
	}
	
	
	@RequestMapping(value="gotoAddEmployee")
	
	public ModelAndView gotoAddEmployee() {
		ModelAndView view=new ModelAndView();
		List<EmployeeModel> employeeList = queryService.getEmployeeList();
		view.addObject("employeeList", employeeList);
		view.setViewName("AddEmployee");
		return view;
	}
	
	
	
@RequestMapping(value="addEmployee")
	
	public ModelAndView addEmployee(@RequestParam(value="employeeName") String employeeName,@RequestParam(value="employeeEmail") String employeeMail,@RequestParam(value="mailType") String mailType) {
		ModelAndView view=new ModelAndView();
		List<EmployeeModel> employeeList = queryService.getEmployeeList();
		queryService.addEmployee(employeeName, employeeMail, mailType);
		view.addObject("employeeList", employeeList);
		view.setViewName("AddEmployee");
		return view;
	}
	
	
	
	
	
	
	

}
