package com.est.test.entity;

import java.util.List;

import org.hibernate.validator.constraints.Email;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class User_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Email
	private String email;
	private  String fullName;
	private String status;
	private String roleName;
	private String created_Date;
	private String updated_Date;
	
	@OneToMany
	@JoinColumn(name = "user_masterid")
	private List<Role_Master> rolemaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getUpdated_Date() {
		return updated_Date;
	}

	public void setUpdated_Date(String updated_Date) {
		this.updated_Date = updated_Date;
	}

	public List<Role_Master> getRolemaster() {
		return rolemaster;
	}

	public void setRolemaster(List<Role_Master> rolemaster) {
		this.rolemaster = rolemaster;
	}

	@Override
	public String toString() {
		return "User_Master [id=" + id + ", username=" + username + ", email=" + email + ", fullName=" + fullName
				+ ", status=" + status + ", roleName=" + roleName + ", created_Date=" + created_Date + ", updated_Date="
				+ updated_Date + ", rolemaster=" + rolemaster + "]";
	}

	public User_Master(Long id, String username, @Email String email, String fullName, String status, String roleName,
			String created_Date, String updated_Date, List<Role_Master> rolemaster) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.status = status;
		this.roleName = roleName;
		this.created_Date = created_Date;
		this.updated_Date = updated_Date;
		this.rolemaster = rolemaster;
	}

	public User_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
