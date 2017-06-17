package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Employee;

@Repository
public class EmployeeDAOImpl {

	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Employee> getAllEmployees() throws DataServiceException {
		List<Employee> employees = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Employee> query = session.createQuery("from Employee", Employee.class);
			employees = query.list();

			logger.info("Employees data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return employees;
	}
	public Employee getEmployeeByEmailId(String email) throws DataServiceException {
		Employee employee = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Employee> query = session.createQuery("from Employee where emailId=:emailId", Employee.class);
			query.setParameter("emailId", email);
			employee = query.getSingleResult();

			logger.info("Employees data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return employee;
	}
	public int checkValidEmployeeByEmailId(String email) throws DataServiceException {
		int employee = 0;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Employee> query = session.createQuery("from Employee where emailId=:email", Employee.class);
			query.setParameter(email, email);
			employee=query.getMaxResults();
			

			logger.info("Employees data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return employee;
	}
}
