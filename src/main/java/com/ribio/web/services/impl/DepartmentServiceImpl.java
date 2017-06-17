package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.DepartmentDAOImpl;
import com.ribio.web.domains.Department;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class DepartmentServiceImpl{

	private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class);

	@Autowired
	DepartmentDAOImpl departmentDao;


	public List<Department> getAllDepartments() throws BusinessServiceException {
		List<Department> departments = null;
		try {
			departments = departmentDao.getAllDepartments();
			logger.info("Departments retrieved successfully.");

		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departments;
	}

}