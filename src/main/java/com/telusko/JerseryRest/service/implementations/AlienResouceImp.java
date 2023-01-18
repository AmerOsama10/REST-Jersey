package com.telusko.JerseryRest.service.implementations;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import com.telusko.JerseryRest.DAO.AlienRepository;
import com.telusko.JerseryRest.model.Alien;
import com.telusko.JerseryRest.model.Response;
import com.telusko.JerseryRest.service.interfaces.AlienResource;

@Path("aliens")
public class AlienResouceImp implements AlienResource {
	AlienRepository repo = new AlienRepository();

	@Override
	@GET
	public String welcome() {
		return "Welcome to alien resource";
	}

	@Override
	@GET
	@Path("alien/{id}")
	public Alien getAlien(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
	
	@Override
	@GET
	@Path("aliens")
	public List<Alien> getAllAliens() {
		return repo.getAllAliens();
	}

	@Override
	@POST
	@Path("alien")
	public Response addAlien(Alien alien) {
		return repo.addAlien(alien);
	}

	@Override
	@PUT
	@Path("alien")
	public Response updateAlien(Alien alien) {
		return repo.updateAlien(alien);
	}

	@Override
	@DELETE
	@Path("alien/{id}")
	public Response deleteAlien(@PathParam("id") int id) {
		return repo.deleteAlien(id);
	}



}
