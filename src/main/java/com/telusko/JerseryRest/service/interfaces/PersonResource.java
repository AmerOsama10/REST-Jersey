package com.telusko.JerseryRest.service.interfaces;

import com.telusko.JerseryRest.model.Person;
import com.telusko.JerseryRest.model.Response;

public interface PersonResource {

	public String welcome();
	
	public Person getPerson(int id);

	public Person[] getAllPersons();

	public Response addPerson(Person person);

	public Response updatePerson(Person person);

	public Response deletePerson(int id);

}