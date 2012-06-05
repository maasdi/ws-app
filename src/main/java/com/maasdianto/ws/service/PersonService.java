package com.maasdianto.ws.service;

import java.util.ArrayList;
import java.util.List;

import com.maasdianto.person.Person;
import com.maasdianto.ws.domain.PersonException;

public class PersonService {
	
	public Person getPerson(int id){
		if(id == 0){
			throw new PersonException("Id can't 0");
		}
		Person person = new Person();
		person.setId(id);
		person.setFirstName("Maas");
		person.setLastName("Dianto");
		return person;
	}
	
	public List<Person> getAllPerson(){
		List<Person> list = new ArrayList<Person>();
		for (int i = 1; i <4; i++) {
			list.add(getPerson(i));
		}
		return list;
	}

}
