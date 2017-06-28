package com.javatpoint.aspectj;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatpoint.service.FactoryService;
import com.javatpoint.service.ShapeService;

/**
 * @author asingha6
 *
 */
public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ApplicationContext cont=new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService=cont.getBean("shapeService",ShapeService.class);
		//System.out.println(shapeService.getTriangle().getName());
		//shapeService.getTriangle().setName("Dummy Name");
		FactoryService factoryService=new FactoryService();
		ShapeService shapeService=(ShapeService)factoryService.getBean("ShapeService");
		shapeService.getCircle();
		
		
	}

}
