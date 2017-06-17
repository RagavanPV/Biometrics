package com.ribio.web.domains;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "EMPLOYEE_SHIFTS")
public class EmployeeShift implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SHIFT_ID", nullable = false)
	private Shift shift;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	private Employee employee;

	@Column(name = "VALID_FROM")
	private Date validFrom;
}