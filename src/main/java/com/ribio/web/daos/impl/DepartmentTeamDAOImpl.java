package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.DepartmentTeam;

@Repository
public class DepartmentTeamDAOImpl {
	private static Logger logger = Logger.getLogger(DepartmentTeamDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<DepartmentTeam> getAllDepartmentTeam() throws DataServiceException {
		List<DepartmentTeam> departmentTeam = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<DepartmentTeam> query = session.createQuery("from DepartmentTeam", DepartmentTeam.class);
			departmentTeam = query.list();

			logger.info("DepartmentTeam data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return departmentTeam;
	}
}
