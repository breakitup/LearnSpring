/**
 * 
 */
package com.javatpoint.SetterInjection;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author asingha6
 *
 */
public class Employee implements InitializingBean,DisposableBean{
	private int id;
	private String name;
	private Address address;
	//private Address address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	void displayInfo(){
		System.out.println(id+" "+name);
		System.out.println(address);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init method called for Employee");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Employee class");
	}
	
}
