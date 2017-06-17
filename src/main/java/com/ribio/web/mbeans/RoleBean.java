package com.ribio.web.mbeans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ribio.web.domains.Role;
import com.ribio.web.services.exception.BusinessServiceException;
import com.ribio.web.services.impl.RoleServiceImpl;

@Component
@Scope("request")
public class RoleBean {

	@Autowired
	RoleServiceImpl seedRolesService;

	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getMeToHomePage() throws BusinessServiceException {
		roles = seedRolesService.getAllRoles();
		return "roles";
	}
}
