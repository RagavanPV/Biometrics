package com.ribio.web.domains;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EMPLOYEE_CODE", nullable = false, unique = true)
	private String code;
	@Column(name = "EMAIL_ID", nullable = false, unique = true)
	private String emailId;

	@Column(nullable = false)
	private String password;
	@Column(nullable=false)
	private Long mobile;

	@Column(name = "ACTIVATION_CODE")
	private String activationCode;

	@Column(name = "LAST_WORKING_DATE")
	private Date lastWorkingDate;

	@Column(name = "SEPERATION_REASON")
	private String seperationReason;

	@Column(name = "CREATED_ON", nullable = false)
	private Timestamp createdOn;

	@Column(name = "IS_ACTIVE")
	private boolean active = true;
}