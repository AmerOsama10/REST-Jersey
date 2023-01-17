package com.telusko.JerseryRest.database;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens2")
public class AlienResource2 {
	AlienRepository2 repo = new AlienRepository2();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		System.out.println("GetAliens called- database		");

		return repo.getAllAliens();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("alien/{id}")
	public Alien getAlien(@PathParam("id") int id) {
		System.out.println("GetAlien called	- database	");

		return repo.getAlien(id);
	}

	@POST
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien createAliens(Alien alien) {
		repo.createAlien(alien);
		System.out.println("createAliens called - database	" + alien.toString());
		return alien;

	}

	@PUT
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien updateAlien(Alien alien) {
		repo.updateAlien(alien);
		System.out.println("updateAlien called - database	" + alien.toString());
		return alien;

	}

	@DELETE
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien alien = repo.getAlien(id);
		repo.deleteAlien(id);
		System.out.println("deleteAlien called - database	" + alien.toString());
		return alien;

	}

}
