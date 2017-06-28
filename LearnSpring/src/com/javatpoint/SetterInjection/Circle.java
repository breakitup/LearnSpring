/**
 * 
 */
package com.javatpoint.SetterInjection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @author asingha6
 *
 */
@Component
public class Circle implements Shape {

	/* (non-Javadoc)
	 * @see com.javatpoint.SetterInjection.Shape#draw()
	 */
	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public Point getCenter() {
		return center;
	}
	//@Required
	//@Autowired
	//@Qualifier("circleRelated")
	@Resource(name="pointb")
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("drawing.circle", null, "Default drawing message",null));
		System.out.println(messageSource.getMessage("drawing.point",new Object []{center.getX(),center.getY()},"Defalut center",null));
		System.out.println(messageSource.getMessage("greeting", null, "DefaultMessage", null));
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Initializing Circle");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy Circle");
	}
}
