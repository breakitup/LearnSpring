/**
 * 
 */
package com.javatpoint.SetterInjection;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author asingha6
 *
 */
public class Address implements InitializingBean{
	private String addressLine1,city,state,country;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
	public String toString(){  
	    return addressLine1+" "+city+" "+state+" "+country;  
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init method called for Address");
	}  
	
}
