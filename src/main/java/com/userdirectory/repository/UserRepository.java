package com.userdirectory.repository;

import java.util.List;

import com.userdirectory.models.Person;

public interface UserRepository {
	public Person findUserById(Integer id);

	public List<Person> getAllUserDetails();

	public Person addUser(Person person);

	public String deleteUser(Integer id);
}
