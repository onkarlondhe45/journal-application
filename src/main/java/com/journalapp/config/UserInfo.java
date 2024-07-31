package com.journalapp.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.journalapp.entity.User;

public class UserInfo implements UserDetails {

	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserInfo(User user) {
		name = user.getName();
		password = user.getPassword();
		authorities = user.getRoles()
				.stream().map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

}
