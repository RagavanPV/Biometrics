package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.DepartmentTeamEmployee;

@Repository
public class DepartmentTeamEmployeeDAOImpl {
	private static Logger logger = Logger.getLogger(DepartmentTeamEmployeeDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<DepartmentTeamEmployee> getAllDepartmentTeamEmployees() throws DataServiceException {
		List<DepartmentTeamEmployee> deptTeamEmpl = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<DepartmentTeamEmployee> query = session.createQuery("from DepartmentTeamEmployee", DepartmentTeamEmployee.class);
			deptTeamEmpl = query.list();

			logger.info("DepartmentTeamEmployee data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return deptTeamEmpl;
	}
}
