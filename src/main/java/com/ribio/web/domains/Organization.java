package com.ribio.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEED_ORGANIZATIONS")
public class Organization implements Serializable {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRootOrg() {
		return rootOrg;
	}

	public void setRootOrg(String rootOrg) {
		this.rootOrg = rootOrg;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "ORGANIZATION_CODE", nullable = false, unique = true)
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ROOT_ORGANIZATION",nullable=true)
	private String rootOrg;

	@Column(name = "IS_ACTIVE")
	private boolean active = true;
}
