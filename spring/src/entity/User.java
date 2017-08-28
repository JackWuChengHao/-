package entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3930349189659649778L;

	@NotEmpty(message="user can not be empty")
	private String username;
	
	@NotEmpty(message="password can not be empty")
	private String password;
	
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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
