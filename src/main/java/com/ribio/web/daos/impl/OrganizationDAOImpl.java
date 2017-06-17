package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Organization;

@Repository
public class OrganizationDAOImpl {
	private static Logger logger = Logger.getLogger(OrganizationDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Organization> getAllOrganizations() throws DataServiceException {
		List<Organization> organization = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Organization> query = session.createQuery("from Organization", Organization.class);
			organization = query.list();

			logger.info("EmployeeShift data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return organization;
	}
}
