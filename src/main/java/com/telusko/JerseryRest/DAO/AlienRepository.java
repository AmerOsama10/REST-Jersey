package com.telusko.JerseryRest.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.telusko.JerseryRest.database.DBConnectionManager;
import com.telusko.JerseryRest.model.Alien;
import com.telusko.JerseryRest.model.Response;

public class AlienRepository {

	private Connection con = null;
	private List<Alien> aliens;

	public AlienRepository() {
		con = DBConnectionManager.connect();
		
	}

	public List<Alien> getAllAliens() {
		aliens = new ArrayList<Alien>();
		try {
			String query = "select * from alien";
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				Alien alien = new Alien();
				alien.setId(result.getInt(1));
				alien.setName(result.getString(2));
				alien.setPoints(result.getInt(3));
				aliens.add(alien);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return aliens;
	}

	public Alien getAlien(int id) {
		Alien alien = new Alien();
		try {
			String query = "select * from alien where id=" + id;
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			if (result.next()) {
				alien.setId(result.getInt(1));
				alien.setName(result.getString(2));
				alien.setPoints(result.getInt(3));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return alien;
	}

	public Response addAlien(Alien newAlien) {

		Response response = new Response();
		Alien alien = getAlien(newAlien.getId());
		if (alien.getId() != 0) {
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}

		try {
			String query = "insert into alien values (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, newAlien.getId());
			st.setString(2, newAlien.getName());
			st.setInt(3, newAlien.getPoints());
			st.executeUpdate();
			response.setStatus(true);
			response.setMessage("Person created successfully");
			return response;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			response.setStatus(false);
			response.setMessage("Error in Executing");
			return response;
		}

	}

	public Response updateAlien(Alien newAlien) {

		Response response = new Response();
		Alien alien = getAlien(newAlien.getId());
		if (alien == null) {
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}

		try {
			String query = "update alien set name =? , points =? where id =?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, newAlien.getName());
			st.setInt(2, newAlien.getPoints());
			st.setInt(3, newAlien.getId());
			st.executeUpdate();
			response.setStatus(true);
			response.setMessage("Person updated successfully");
			return response;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			response.setStatus(false);
			response.setMessage("Error in Executing");
			return response;
		}

	}

	public Response deleteAlien(int id) {

		Response response = new Response();
		Alien person = getAlien(id);
		if (person == null) {
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		try {
			String query = "delete from alien where id =?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
			response.setStatus(true);
			response.setMessage("Person deleted successfully");
			return response;
		} catch (SQLException e) {
			response.setStatus(false);
			response.setMessage("Error in Executing");
			return response;
		}

	}
}
