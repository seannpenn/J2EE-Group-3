package Group3.Group3prelims.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String user_fname;
	private String user_lname;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_username")
	private String username;
	private String user_password;
	private String is_logged_in;
	private String roles;
	
	
	public String getUser_fname() {
		return user_fname;
	}

	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}

	public String getUser_lname() {
		return user_lname;
	}

	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}

	public String getUser_username() {
		return username;
	}

	public void setUser_username(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return email;
	}

	public void setUser_email(String email) {
		this.email = email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getIs_logged_in() {
		return is_logged_in;
	}

	public void setIs_logged_in(String is_logged_in) {
		this.is_logged_in = is_logged_in;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
}
