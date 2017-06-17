package com.ribio.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SEED_ORGANIZATIONS")
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

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
