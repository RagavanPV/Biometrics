package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Team;

@Repository
public class TeamDAOImpl {

	private static Logger logger = Logger.getLogger(TeamDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Team> getAllTeams() throws DataServiceException {
		List<Team> team = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Team> query = session.createQuery("from Team", Team.class);
			team = query.list();

			logger.info("Employees data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return team;
	}
}
