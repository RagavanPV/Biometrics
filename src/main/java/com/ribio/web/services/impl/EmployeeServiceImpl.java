package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.EmployeeDAOImpl;
import com.ribio.web.domains.Employee;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class EmployeeServiceImpl{

	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDAOImpl departmentDao;


	public List<Employee> getAllEmployees() throws BusinessServiceException {
		List<Employee> departmentTeams = null;
		try {
			departmentTeams = departmentDao.getAllEmployees();
			logger.info("Employee retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentTeams;
	}
	public Employee getEmployeeByEmailId(String email) throws BusinessServiceException {
		Employee employee = null;
		try {
			employee = departmentDao.getEmployeeByEmailId(email);
			logger.info("Employee retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return employee;
	}
	public int checkValidEmployeeByEmailId(String email) throws BusinessServiceException {
		int employee = 0;
		try {
			employee = departmentDao.checkValidEmployeeByEmailId(email);
			logger.info("Employee retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return employee;
	}

}