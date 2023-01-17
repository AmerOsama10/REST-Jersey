package com.telusko.JerseryRest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
			System.out.println("GetAliens called	");
			
			return repo.getAliens();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("alien/{id}")
	public Alien getAlien(@PathParam("id")int id) {
			System.out.println("GetAlien called	");
			
			return repo.getAlien(id);
	}

	@POST
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien createAliens(Alien alien) {
			System.out.println("createAliens called	"+alien.toString());
			repo.createAlien(alien);
			return alien;
			
	}
	
	
	
	
}