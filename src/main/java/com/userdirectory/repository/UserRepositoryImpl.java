package com.userdirectory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userdirectory.models.Person;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Person findUserById(Integer id) {
		Person p = new Person();
		p = entityManager.find(Person.class, id);
		return p;
	}

	@Override
	public List<Person> getAllUserDetails() {
		Query query = entityManager.createNativeQuery("select * from userinfo");
		List<Person> userList = query.getResultList();
		return userList;
	}

	@Override
	public Person addUser(Person person) {
		if(person.getId() == null) {
			entityManager.persist(person);
		}else {
			entityManager.merge(person);
		}
		return person;
	}

	@Override
	public String deleteUser(Integer id) {
		Person person = entityManager.find(Person.class, id);
		if(person.getId() != null) {
			entityManager.remove(person);
			return "200";
		}
		return "Error";
	}

}
