package com.userdirectory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userdirectory.models.Person;
import com.userdirectory.service.UserService;

@RestController
public class UserDirectoryController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/getUser")
	public Person findUserById(@RequestParam(value = "id") Integer id) {
		Person person = userService.findUserById(id);
		return person;
	}

	@GetMapping(value = "/getAll")
	public List<Person> getAllUserDetails(){
		List<Person> userList = new ArrayList<Person>();
		userList = userService.getAllUserDetails();
		return userList;
	}

	@PostMapping(value = "/addUser")
	public Person addUser(@RequestBody Person person) {
		Person p2 = userService.addUser(person);
		return p2;
	}

	@GetMapping(value = "/delete")
	public String deleteUser(@RequestParam(value = "id")Integer id) {
		return userService.deleteUser(id);
	}
}
