package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.EmployeeShiftDAOImpl;
import com.ribio.web.domains.EmployeeShift;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class EmployeeShiftServiceImpl{

	private static Logger logger = Logger.getLogger(EmployeeShiftServiceImpl.class);

	@Autowired
	EmployeeShiftDAOImpl departmentDao;


	public List<EmployeeShift> getAllEmployeeShifts() throws BusinessServiceException {
		List<EmployeeShift> departmentTeams = null;
		try {
			departmentTeams = departmentDao.getAllEmployeeShifts();
			logger.info("DepartmentTeam retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departmentTeams;
	}

}