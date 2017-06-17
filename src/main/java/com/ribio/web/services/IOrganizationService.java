package com.ribio.web.services;

import java.util.List;

import com.ribio.web.domains.Organization;
import com.ribio.web.services.exception.BusinessServiceException;


public interface IOrganizationService{

	List<Organization> getAllOrgainzations() throws BusinessServiceException;
}
