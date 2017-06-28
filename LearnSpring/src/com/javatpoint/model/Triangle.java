/**
 * 
 */
package com.javatpoint.model;

/**
 * @author asingha6
 *
 */
public class Triangle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Traingle method called");
		//throw (new RuntimeException());
	}
	
}
