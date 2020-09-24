package com.croods.jpadatatable.datatabledemo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.croods.jpadatatable.company.Company;
import com.croods.jpadatatable.company.CompanyRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private CompanyRepository companyRepository;

	public User saveUser(User user, Long companyId) {
		Company company = companyRepository.findById(companyId).orElse(null);
		company.setUser(user);
		return userRepository.save(user);
	}

	public DataTablesOutput<User> getAllUsers(@Valid DataTablesInput input) {
		return userRepository.findAll(input);
	}
}
