package com.training.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Circle implements Shape {
	private int radius;
	private double area;
	private String id;
	private static Logger shapelogger = LogManager.getLogger(Circle.class.getName());

	public Circle(int radius, String id) {
		shapelogger.info("Circle Constructor is Created Successfully");
		this.radius = radius;
		this.id = id;
	}

	public String area() {
		area = Math.PI * radius * radius;
		// TODO Auto-generated method stub
		String result = "Area of Circle is " + area;
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub

		return "Circle";
	}

}