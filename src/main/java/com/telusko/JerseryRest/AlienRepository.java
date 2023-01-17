package com.telusko.JerseryRest;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	List<Alien>aliens ;
	Alien a1 , a2 ;
	public AlienRepository() {
		Alien a1 = new Alien();
		a1.setId(1);
		a1.setName("Amer");
		a1.setPoints(111);
		Alien a2 = new Alien();
		a2.setId(2);
		a2.setName("Ahmed");
		a2.setPoints(222);
		aliens = new ArrayList<>();
		aliens.add(a1);
		aliens.add(a2);

	}
	
	public List<Alien>getAliens(){
		return aliens;
	}
	
	
	public Alien getAlien(int id){
		for(Alien a : aliens) {
			if(a.getId()== id)
				return a;
		}
			
		return null;
	}
	
	
	public void createAlien(Alien alien) {
		aliens.add(alien);
		
	}

}
