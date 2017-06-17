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

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "DEPARTMENT_CODE", nullable = false, unique = true)
	private String code;

	@Column(name = "IS_ACTIVE")
	private boolean active = true;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organization;
}