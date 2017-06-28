/**
 * 
 */
package com.javatpoint;

/**
 * @author asingha6
 *
 */
public class Address {
	private String city;
	private String state;
	private String country;

	Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String toString(){
		return city+" "+state+" "+country;
	}

}
