package com.ipd12.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	private int id;
	private String name;
	private String password;
	private String firstname;
	private String lastname;
	private String city;
	private String postal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", city=" + city + ", postal=" + postal + "]";
	}
}
