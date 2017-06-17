package com.ribio.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "department_team_employees", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "DEPARTMENT_TEAM_ID", "EMPLOYEE_ID" }) })
public class DepartmentTeamEmployee implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DepartmentTeam getDepartmentTeam() {
		return departmentTeam;
	}

	public void setDepartmentTeam(DepartmentTeam departmentTeam) {
		this.departmentTeam = departmentTeam;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_TEAM_ID", nullable = false)
	private DepartmentTeam departmentTeam;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	private Employee employee;

	@Column(name = "IS_ACTIVE")
	private boolean active = true;

}