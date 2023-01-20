package com.est.test.entity;

import org.hibernate.validator.constraints.Email;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
public class Role_Master {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String rolename;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Role_Master [Id=" + Id + ", rolename=" + rolename + "]";
	}
	public Role_Master(Long id, String rolename) {
		super();
		Id = id;
		this.rolename = rolename;
	}
	public Role_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
