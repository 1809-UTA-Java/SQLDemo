package com.revature.JDBCDemo2.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.JDBCDemo2.model.Animal;
import com.revature.JDBCDemo2.util.ConnectionUtil;

public class AnimalDao {
	
	public List<Animal> getAnimals() {
		PreparedStatement ps = null;
		Animal a = null;
		List<Animal> animals = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ANIMALS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int legs = rs.getInt("legs");
				
				a = new Animal(id, name, age, legs);
				animals.add(a);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return animals;
	}

}
