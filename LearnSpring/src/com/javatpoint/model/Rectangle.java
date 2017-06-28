/**
 * 
 */
package com.javatpoint.model;

/**
 * @author asingha6
 *
 */
public class Rectangle {
	private int id;
	private String name;
	
	public Rectangle(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
