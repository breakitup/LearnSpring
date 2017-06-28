/**
 * 
 */
package com.javatpoint.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javatpoint.dto.Address;
import com.javatpoint.dto.EmployeeDetails;
import com.javatpoint.dto.UserDetails;

/**
 * @author asingha6
 *
 */
public class HibernateTest {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		//creating a new user 
		UserDetails user=new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		//user.setAddress("First User Address");
		user.setDescription("First User Description");
		user.setDate(new Date());
		
		//creating address object to inject into user
		Address homeAddress=new Address();
		homeAddress.setCity("Bangalore");
		homeAddress.setStreet("MG Road");
		user.setHomeAddress(homeAddress);
		
		//creating address object to inject into user
		Address officeAddress=new Address();
		officeAddress.setCity("Bangalore");
		officeAddress.setStreet("JP Morgan");
		user.setOfficeAddress(officeAddress);
		
		//creating a session and saving the user object into database as a relation
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		//fetching the same user relation from the db
		session = sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails) session.get(UserDetails.class, 1);
		System.out.println("Get User Details from db,"+user.getUserName()+" address is "+user.getHomeAddress().getStreet());
		session.close();
		
		//creating a new object Employee and saving it into db
		EmployeeDetails employee=new EmployeeDetails();
		employee.setUserName("First Employee");
		employee.getAddress().add(officeAddress);
		employee.getAddress().add(homeAddress);
		
		//opening a session and saving the object as a relation into DB
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		//Fetching the same Employee Relation from db
		session=sessionFactory.openSession();
		session.beginTransaction();
		EmployeeDetails fetchEmployee=(EmployeeDetails)session.get(EmployeeDetails.class,1);
		session.close();
		System.out.println("Getting Employee Details from DB"+fetchEmployee.getUserId()+" "+fetchEmployee.getUserName()+" "+fetchEmployee.getAddress().size());
		
	}

}
