package com.ribio.web.mbeans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ribio.web.domains.Organization;
import com.ribio.web.services.exception.BusinessServiceException;
import com.ribio.web.services.impl.OrganizationServiceImpl;

@Component
@Scope("request")
public class OrganizationBean {

	@Autowired
	OrganizationServiceImpl seedRolesService;

	private List<Organization> organizations;

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public String getMeToHomePage() throws BusinessServiceException {
		organizations = seedRolesService.getAllOrganizations();
		return "organizations";
	}
}
