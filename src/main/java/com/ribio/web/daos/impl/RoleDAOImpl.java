package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Role;

@Repository
public class RoleDAOImpl {
	private static Logger logger = Logger.getLogger(RoleDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Role> getAllRoles() throws DataServiceException {
		List<Role> employees = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Role> query = session.createQuery("from Role", Role.class);
			employees = query.list();

			logger.info("EmployeeShift data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return employees;
	}
}
