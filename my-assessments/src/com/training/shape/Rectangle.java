package com.training.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rectangle implements Shape {
	private int length;
	private int breadth;
	private double area;
	private String id;
	private static Logger shapelogger = LogManager.getLogger(Rectangle.class.getName());

	Rectangle(int length, int breadth, String id) {
		shapelogger.debug("Rectangle Constructor is Created Successfully");
		this.length = length;
		this.breadth = breadth;
		this.id = id;

		// TODO Auto-generated constructor stub
	}

	public String area() {
		area = length * breadth;
		String result = "Area of Rectangle is " + area;
		return result;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

}
