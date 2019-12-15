package io.mk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.mk.dao.UserDao;
import io.mk.model.LoginUser;

@Service
public class StudentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		LoginUser user = userDao.findByUserName(username);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));

		boolean enbl = user.getEnabled() == 1 ? true : false;
		return new User(user.getUsername(), user.getPassword(), enbl, true, true, true, authorities);
	}
}