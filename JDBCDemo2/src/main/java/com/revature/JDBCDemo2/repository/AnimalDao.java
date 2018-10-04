package com.revature.JDBCDemo2.repository;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.JDBCDemo2.model.Animal;
import com.revature.JDBCDemo2.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

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
	
	public Animal getAnimalByName(String n) {
		PreparedStatement ps = null;
		Animal a = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ANIMALS WHERE NAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int legs = rs.getInt("legs");
				
				a = new Animal(id, name, age, legs);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		return a;
	}
	
	public void birthday(int aid, int yta) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL BIRTHDAY_SP(?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, aid);
			cs.setInt(2, yta);
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getAnimalsBySp() {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{ CALL GET_ANIMALS(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
