package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.RoleDAOImpl;
import com.ribio.web.domains.Role;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class RoleServiceImpl{

	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	RoleDAOImpl roleDAO;


	public List<Role> getAllRoles() throws BusinessServiceException {
		List<Role> roles = null;
		try {
			roles = roleDAO.getAllRoles();
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		logger.info("Organizations retrieved successfully.");
		return roles;
	}

}