package com.telusko.JerseryRest.service.interfaces;

import java.util.List;

import com.telusko.JerseryRest.model.Alien;
import com.telusko.JerseryRest.model.Response;

public interface AlienResource {


	public String welcome();
	
	public Alien getAlien(int id);

	public List<Alien> getAllAliens();

	public Response addAlien(Alien alien);

	public Response updateAlien(Alien alien);

	public Response deleteAlien(int id);

}