package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.DepartmentTeamDAOImpl;
import com.ribio.web.domains.DepartmentTeam;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class DepartmentTeamServiceImpl{

	private static Logger logger = Logger.getLogger(DepartmentTeamServiceImpl.class);

	@Autowired
	DepartmentTeamDAOImpl departmentDao;


	public List<DepartmentTeam> getAllDepartments() throws BusinessServiceException {
		List<DepartmentTeam> departmentTeams = null;
		try {
			departmentTeams = departmentDao.getAllDepartmentTeam();
			logger.info("DepartmentTeam retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentTeams;
	}

}