package com.telusko.JerseryRest.DAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.telusko.JerseryRest.model.Person;
import com.telusko.JerseryRest.model.Response;

public class PersonRepository {

	private static Map<Integer, Person> persons;

	public PersonRepository() {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Amer");
		p1.setAge(22);
		Person p2 = new Person();
		p2.setId(2);
		p2.setName("Ahmed");
		p2.setAge(25);
		persons = new HashMap<Integer, Person>();
		persons.put(p1.getId(), p1);
		persons.put(p2.getId(), p2);

	}

	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] person = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			person[i] = persons.get(id);
			i++;
		}
		return person;
	}

	public Person getPerson(int id) {
		return persons.get(id);
	}

	public Response addPerson(Person newPerson) {
		Response response = new Response();
		Person person = getPerson(newPerson.getId());
		System.out.println("newPerson id :" + newPerson.getId() + "     person :" +person);
		//if u find this object in your set
		if (person != null) {
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;

		}
			persons.put(newPerson.getId(), newPerson);
			response.setStatus(true);
			response.setMessage("Person created successfully");
			return response;


	}

	public Response updatePerson(Person newPerson) {
		
		Response response = new Response();
		Person person = getPerson(newPerson.getId());
		if (person != null) {
			person.setName(newPerson.getName());
			person.setAge(newPerson.getAge());
			response.setStatus(true);
			response.setMessage("Person updated successfully");
			return response;

		} 
		response.setStatus(false);
		response.setMessage("Person Doesn't Exists");
		return response;

		

	}

	public Response deletePerson(int id) {
		Response response = new Response();
		
		Person person = getPerson(id);
		if (person != null) {
			persons.remove(id);
			response.setStatus(true);
			response.setMessage("Person deleted successfully");
			return response;

		} 
		response.setStatus(false);
		response.setMessage("Person Doesn't Exists");
		return response;
}
}
