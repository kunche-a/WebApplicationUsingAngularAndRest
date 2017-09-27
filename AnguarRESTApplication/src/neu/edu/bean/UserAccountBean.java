package neu.edu.bean;

import java.util.Date;
import java.util.List;

public class UserAccountBean {
	
	private String username;
	private String name;
	private Date age;
	private String role;
	private int id;
	private String email;
	private String phone;
	private String password;
	
	
	public UserAccountBean() {
		// TODO Auto-generated constructor stub
	}
		
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getAge() {
		return age;
	}


	public void setAge(Date age) {
		this.age = age;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	

	
}
