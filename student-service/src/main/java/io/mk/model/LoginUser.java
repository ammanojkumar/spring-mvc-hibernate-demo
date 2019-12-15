package io.mk.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="LOGIN_USER")
public class LoginUser {

	@Id
	private String username;
	private String password;
	private int enabled;
	private String role;

	public LoginUser() {
	}

	public LoginUser(String username, String password, int enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public LoginUser(String username, String password, int enabled, String role) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static void main(String[] args) {
		String encoded = new BCryptPasswordEncoder().encode("d");
		System.out.println(encoded);
	}

}
