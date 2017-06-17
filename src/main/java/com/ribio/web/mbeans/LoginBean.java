package com.ribio.web.mbeans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ribio.web.domains.Employee;
import com.ribio.web.services.exception.BusinessServiceException;
import com.ribio.web.services.impl.EmployeeServiceImpl;

@Component
@Scope("request")
public class LoginBean {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws BusinessServiceException {
		Employee e = employeeServiceImpl.getEmployeeByEmailId(getEmailId());
		System.out.println(e);
		if (e != null) {
			if (e.getPassword().equals(getPassword())) {
				System.out.println(e.getPassword() + " " + getPassword());
				FacesContext context = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
				session.setAttribute("employee", e);
				return "dashboard?faces-redirect=true";
			}
		}
		return "login";

	}
}
