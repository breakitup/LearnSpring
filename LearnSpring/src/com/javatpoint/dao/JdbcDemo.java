/**
 * 
 */
package com.javatpoint.dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatpoint.model.Rectangle;

/**
 * @author asingha6
 *
 */
public class JdbcDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cont=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=(JdbcDaoImpl)cont.getBean("jdbcDaoImpl");
		SimpleJdbcDaoImpl simpleDao=(SimpleJdbcDaoImpl)cont.getBean("simpleJdbcDaoImpl");
		/*
		dao.insertRectangle(new Rectangle(3,"Third Circle"));
		System.out.println(dao.getRectangle(2).getName());
		System.out.println(dao.getRectangleCount());
		System.out.println(dao.getRectangleName(1));
		System.out.println(dao.getRectangleForId(2).getName());
		System.out.println("Total Number of Rectangles="+dao.getAllRectangle().size());
		dao.createRectangleTable();
		*/
		/*
		dao.insertRectangleUsingNamedSpaceJdbcTemplate(new Rectangle(4,"Fourth Circle"));
		System.out.println("Total Number of Rectangles="+dao.getAllRectangle().size());
		System.out.println(dao.getRectangleForId(4).getName());
		*/
		System.out.println("Total Number of Rectangles="+dao.getAllRectangle().size());
		
	}

}
