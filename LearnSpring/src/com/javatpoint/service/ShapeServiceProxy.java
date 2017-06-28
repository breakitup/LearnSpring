/**
 * 
 */
package com.javatpoint.service;

import com.javatpoint.aspect.LoggingAspect;
import com.javatpoint.model.Circle;

/**
 * @author asingha6
 *
 */
public class ShapeServiceProxy extends ShapeService {
	public Circle getCircle(){
		new LoggingAspect().LoggingAdvice();
		return super.getCircle();
	}

}
