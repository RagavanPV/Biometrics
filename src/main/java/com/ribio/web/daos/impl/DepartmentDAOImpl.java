package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Department;

@Repository
public class DepartmentDAOImpl {
	private static Logger logger = Logger.getLogger(DepartmentDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Department> getAllDepartments() throws DataServiceException {
		List<Department> department = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Department> query = session.createQuery("from Department", Department.class);
			department = query.list();

			logger.info("Employees data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return department;
	}
}
