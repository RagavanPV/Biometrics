package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.DepartmentTeamEmployeeDAOImpl;
import com.ribio.web.domains.DepartmentTeamEmployee;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class DepartmentTeamEmployeeServiceImpl{

	private static Logger logger = Logger.getLogger(DepartmentTeamEmployeeServiceImpl.class);

	@Autowired
	DepartmentTeamEmployeeDAOImpl departmentDao;


	public List<DepartmentTeamEmployee> getAllDepartmentTeamEmployees() throws BusinessServiceException {
		List<DepartmentTeamEmployee> departmentTeams = null;
		try {
			departmentTeams = departmentDao.getAllDepartmentTeamEmployees();
			logger.info("DepartmentTeamEmployee retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentTeams;
	}

}