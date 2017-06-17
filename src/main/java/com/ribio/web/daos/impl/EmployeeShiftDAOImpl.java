package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.EmployeeShift;

@Repository
public class EmployeeShiftDAOImpl {
	private static Logger logger = Logger.getLogger(EmployeeShiftDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<EmployeeShift> getAllEmployeeShifts() throws DataServiceException {
		List<EmployeeShift> employees = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<EmployeeShift> query = session.createQuery("from EmployeeShift", EmployeeShift.class);
			employees = query.list();

			logger.info("EmployeeShift data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return employees;
	}
}
