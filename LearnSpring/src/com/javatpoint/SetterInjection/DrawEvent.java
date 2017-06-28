/**
 * 
 */
package com.javatpoint.SetterInjection;

import org.springframework.context.ApplicationEvent;

/**
 * @author asingha6
 *
 */
public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return "Draw Event Occured";
	}
}
