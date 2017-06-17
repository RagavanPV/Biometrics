package com.ribio.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seed_roles")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRoleCode() {
	return roleCode;
}
public void setRoleCode(String roleCode) {
	this.roleCode = roleCode;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
@Column(name="NAME")
private String name;
@Column(name="ROLE_CODE")
private String roleCode;
@Column(name="IS_ACTIVE")
private boolean isActive;


}
