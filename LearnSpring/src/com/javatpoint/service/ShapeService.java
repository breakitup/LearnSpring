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
public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	public Circle getCircle() {
		System.out.println("get Cicle Method");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
