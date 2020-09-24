package com.croods.jpadatatable.datatabledemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.croods.jpadatatable.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile_no")
	private String mobileNo;
	
	
	@ManyToOne()
	private Company company;

	@Column(name = "is_deleted", length = 1, columnDefinition = "int default 0")
	@JsonIgnore
	private int isDeleted;
}
