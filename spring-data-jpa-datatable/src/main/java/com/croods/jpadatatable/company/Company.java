package com.croods.jpadatatable.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.croods.jpadatatable.datatabledemo.User;

import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;
	
	private String companyName;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private User user;
}
