package com.croods.jpadatatable.datatabledemo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public ModelAndView getindexPage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/datalist", method = RequestMethod.GET)
	public DataTablesOutput<User> list(@Valid DataTablesInput input) {
		return userService.getAllUsers(input);
	}

	@RequestMapping(value = "/datalist", method = RequestMethod.POST)
	public DataTablesOutput<User> listPOST(@Valid @RequestBody DataTablesInput input) {
		return userService.getAllUsers(input);
	}

	@PostMapping("/add/{companyId}")
	public ResponseEntity<User> saveUser(@RequestBody User user, @PathVariable Long companyId) {
		return new ResponseEntity<User>(userService.saveUser(user, companyId), HttpStatus.OK);
	}

}
