package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.OrganizationDAOImpl;
import com.ribio.web.domains.Organization;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class OrganizationServiceImpl{

	private static Logger logger = Logger.getLogger(OrganizationServiceImpl.class);

	@Autowired
	OrganizationDAOImpl roleDAO;


	public List<Organization> getAllOrganizations() throws BusinessServiceException {
		List<Organization> roles = null;
		try {
			roles = roleDAO.getAllOrganizations();
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		logger.info("Organizations retrieved successfully.");
		return roles;
	}

}