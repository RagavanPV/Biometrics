package com.ribio.web.domains;

import java.io.Serializable;
import java.sql.Time;

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
@Table(name = "SHIFTS")

public class Shift implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public Time getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Time timeZone) {
		this.timeZone = timeZone;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getWaiver() {
		return waiver;
	}

	public void setWaiver(Integer waiver) {
		this.waiver = waiver;
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
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organization;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "SHIFT_CODE", nullable = false, unique = true)
	private String code;

	@Column(name = "TIME_ZONE", nullable = false)
	private Time timeZone;

	@Column(name = "START_TIME", nullable = false)
	private Time startTime;

	@Column(name = "END_TIME", nullable = false)
	private Time endTime;

	@Column(name = "SHIFT_DURATION", nullable = false)
	private Integer duration;

	@Column(name = "SHIFT_WAIVER", nullable = false)
	private Integer waiver;

	@Column(name = "IS_ACTIVE")
	private boolean active = true;
}