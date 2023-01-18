package com.telusko.JerseryRest.service.implementations;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.telusko.JerseryRest.DAO.PersonRepository;
import com.telusko.JerseryRest.model.Person;
import com.telusko.JerseryRest.model.Response;
import com.telusko.JerseryRest.service.interfaces.PersonResource;

@Path("/person")
public class PersonResourceImpl implements PersonResource {
	
	PersonRepository repo = new PersonRepository();
	
	@GET
	public String welcome() {
		return "Welcome to person resource";
	}
	
	@Override
	@GET
	@Path("/get/{id}")
	public Person getPerson(@PathParam("id") int id) {
		return repo.getPerson(id);
	}

	
	@Override
	@GET
	@Path("/get")
	public Person[] getAllPersons() {
	return repo.getAllPersons();
	}
	
	@Override
	@POST
	@Path("/add")
	public Response addPerson(Person person) {
		return repo.addPerson(person);
	}

	@Override
	@PUT
	@Path("/update")
	public Response updatePerson(Person person) {
		return repo.updatePerson(person);
	}
	
	@Override
	@DELETE
	@Path("/delete/{id}")
	public Response deletePerson(@PathParam("id") int id) {
		return repo.deletePerson(id);
	}



}