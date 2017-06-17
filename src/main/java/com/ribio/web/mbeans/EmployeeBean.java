package com.ribio.web.mbeans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ribio.web.domains.Employee;
import com.ribio.web.services.exception.BusinessServiceException;
import com.ribio.web.services.impl.EmployeeServiceImpl;

@Component
@Scope("request")
public class EmployeeBean {

	@Autowired
	EmployeeServiceImpl seedEmployeesService;

	private List<Employee> employee;

	public List<Employee> getOrganizations() {
		return employee;
	}

	public void setOrganizations(List<Employee> employee) {
		this.employee = employee;
	}

	public String getAllEmployees() throws BusinessServiceException {
		System.out.println("hello");
		employee = seedEmployeesService.getAllEmployees();
		System.out.println(employee);
		return "manageEmployee?faces-redirect=true";
	}
}
