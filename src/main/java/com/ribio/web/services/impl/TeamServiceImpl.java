package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.TeamDAOImpl;
import com.ribio.web.domains.Team;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class TeamServiceImpl{

	private static Logger logger = Logger.getLogger(TeamServiceImpl.class);

	@Autowired
	TeamDAOImpl teamDAO;


	public List<Team> getAllTeams() throws BusinessServiceException {
		List<Team> teams = null;
		try {
			teams = teamDAO.getAllTeams();
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		logger.info("Organizations retrieved successfully.");
		return teams;
	}

}