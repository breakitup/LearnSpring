/**
 * 
 */
package com.javatpoint.service;

import com.javatpoint.model.Circle;
import com.javatpoint.model.Triangle;

/**
 * @author asingha6
 *
 */
public class FactoryService {
	
	public Object getBean(String beanType){
		if(beanType.equals("ShapeService"))
			return new ShapeServiceProxy();
		else if (beanType.equals("Circle"))
			return new Circle();
		else if(beanType.equals("Triangle"))
			return new Triangle();
		return null;
	}

}
