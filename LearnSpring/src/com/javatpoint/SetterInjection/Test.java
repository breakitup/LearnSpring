/**
 * 
 */
package com.javatpoint.SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author asingha6
 *
 */
public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = (Employee) context.getBean("employeebean");
		e.displayInfo();
		Triangle t=(Triangle)context.getBean("triangle");
		t.draw();
		Shape c=(Shape)context.getBean("circle");
		c.draw();
		//System.out.println(context.getMessage("greeting", null, "Default Message",null));
	}
}
