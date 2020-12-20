package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="admin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  admin_id;
	@Column(length = 30)
	private String  first_name;
	@Column(length = 30)
	private String  last_name;
	@Column(length = 30,unique = true)
	private String   email;
	private String password;
	private String address;
	@Column(length = 12)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	
	
	
	   public 	Admin() {
		   System.out.println("in doctor constructor "+getClass().getName());
	   }
	
	
	public Admin(String first_name, String last_name, String email, String password, String address, String phone,
			Gender gender) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}


	public Integer getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}


	public String getFirstName() {
		return first_name;
	}


	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}


	public String getLastName() {
		return last_name;
	}


	public void setLastName(String lastName) {
		this.last_name = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", firstName=" + first_name + ", lastName=" + last_name + ", email="
				+ email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", gender=" + gender
				+ "]";
	}
	
	
	
	
}
