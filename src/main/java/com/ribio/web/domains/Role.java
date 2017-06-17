package com.ribio.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="seed_roles")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(name="NAME")
private String name;
@Column(name="ROLE_CODE")
private String roleCode;
@Column(name="IS_ACTIVE")
private boolean isActive;


}
