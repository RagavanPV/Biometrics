package com.ribio.web.daos;

import java.util.List;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.domains.Organization;


public interface IOrganizationDao {

	List<Organization> retrieveAllOrganizations() throws DataServiceException;
}
