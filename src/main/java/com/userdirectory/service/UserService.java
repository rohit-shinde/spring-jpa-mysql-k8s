package com.userdirectory.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdirectory.models.Person;
import com.userdirectory.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public Person findUserById(Integer id) {
		Person person = new Person();
		person = userRepository.findUserById(id);
		return person;
	}

	@Transactional
	public List<Person> getAllUserDetails(){
		List<Person> userList = new ArrayList<Person>();
		userList = userRepository.getAllUserDetails();
		return userList;
	}

	@Transactional
	public Person addUser(Person person) {
		Person p2 = userRepository.addUser(person);
		return p2;
	}

	@Transactional
	public String deleteUser(Integer id) {
		String response = userRepository.deleteUser(id);
		return response;
	}
}
