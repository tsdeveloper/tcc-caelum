package com.caelum.tccjavaweb.account;

import com.caelum.tccjavaweb.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;


	private Instant created;

    protected Account() {

	}

	
	public Account(String email, String password, List<Role> roles) {
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Instant getCreated() {
		return created;
	}
}
