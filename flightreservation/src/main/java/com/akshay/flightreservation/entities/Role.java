package com.akshay.flightreservation.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287375944788127182L;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(final Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return name;
	}
}
