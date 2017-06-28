/**
 * 
 */
package com.javatpoint;

/**
 * @author asingha6
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
//		Resource resource = new ClassPathResource("applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) context.getBean("studentbean");
		student.displayInfo();
		Employee emp = (Employee) context.getBean("employeebean");
		emp.show();
		Question qs=(Question)context.getBean("questionbeanwithanswers");
		qs.displayInfo();
		Question qs1=(Question)context.getBean("questionbeanwithcomments");
		qs1.displayInfo();
	}
}