/**
 * 
 */
package com.javatpoint.SetterInjection;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author asingha6
 *
 */
public class Triangle implements Shape,ApplicationEventPublisherAware{
	private Point pointa;
	private Point pointb;
	private Point pointc;
	private ApplicationEventPublisher publisher;
	
	public Point getPointa() {
		return pointa;
	}

	public void setPointa(Point pointa) {
		this.pointa = pointa;
	}

	public Point getPointb() {
		return pointb;
	}

	public void setPointb(Point pointb) {
		this.pointb = pointb;
	}

	public Point getPointc() {
		return pointc;
	}

	public void setPointc(Point pointc) {
		this.pointc = pointc;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Triangle");
		System.out.println("Point A=("+pointa.getX()+","+pointa.getY()+")");
		System.out.println("Point B=("+pointb.getX()+","+pointb.getY()+")");
		System.out.println("Point C=("+pointc.getX()+","+pointc.getY()+")");
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
	}

}
