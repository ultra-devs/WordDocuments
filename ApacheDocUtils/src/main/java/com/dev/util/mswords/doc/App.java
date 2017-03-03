package com.dev.util.mswords.doc;

import java.util.Arrays;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Lokesh");
		employee.setLastName("Gupta");
		employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
		Gson gson = new Gson();
		String jason=gson.toJson(employee);
		System.out.println(jason);	
		Gson gsonreeverse = new Gson();
		Employee employee2=gsonreeverse.fromJson(jason, Employee.class);
		//calling to string
		System.out.println(employee2.toString());
	}
}
