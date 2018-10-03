package com.revature.JDBCDemo2;

import java.util.List;

import com.revature.JDBCDemo2.model.Animal;
import com.revature.JDBCDemo2.repository.AnimalDao;

public class App {
	public static void main(String[] args) {
		AnimalDao adao = new AnimalDao();
		List<Animal> animals = adao.getAnimals();
		for (Animal a : animals) {
			System.out.println(a);
		}
	}
}
