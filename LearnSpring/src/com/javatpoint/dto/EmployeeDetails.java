/**
 * 
 */
package com.javatpoint.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


/**
 * @author asingha6
 *
 */
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private int userId;
	@Column(name = "User_Name")
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Employee_Address",
	joinColumns=@JoinColumn(name="User_ID")
	)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="Address_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> address=new ArrayList<Address>();

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
