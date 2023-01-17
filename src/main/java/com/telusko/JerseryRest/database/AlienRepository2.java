package com.telusko.JerseryRest.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AlienRepository2 {

	Connection con=null;
	public AlienRepository2() {

		con = DBConnectionManager.connect();

	}

	public List<Alien> getAllAliens() {
		List<Alien> aliens = new ArrayList<>();
		String query = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				Alien a = new Alien();
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
				aliens.add(a);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return aliens;
	}

	public Alien getAlien(int id) {
		List<Alien> aliens = new ArrayList<>();
		Alien a = new Alien();
		String query = "select * from alien where id=" + id;
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			if (result.next()) {
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return a;
	}

	public void createAlien(Alien alien) {
		String query = "insert into alien values (?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, alien.getId());
			st.setString(2, alien.getName());
			st.setInt(3, alien.getPoints());
			st.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void updateAlien(Alien alien) {
		String query = "update alien set name =? , points =? where id =?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, alien.getName());
			st.setInt(2, alien.getPoints());
			st.setInt(3, alien.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void deleteAlien(int id ) {
		String query = "delete from alien where id =?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
}
