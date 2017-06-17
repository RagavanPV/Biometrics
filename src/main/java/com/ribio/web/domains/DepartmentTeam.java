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
@Table(name = "department_teams", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "DEPARTMENT_ID", "TEAM_ID" }) })
public class DepartmentTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false)
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID", nullable = false)
	private Team team;
}