package com.training.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Square implements Shape {
	private double side;
	private double area;
	private String id;
	private static Logger shapelogger = LogManager.getLogger(Square.class.getName());

	Square(double side, String id) {
		shapelogger.debug("Square Constructor is created Successfully");
		this.side = side;
		this.id = id;
	}

	public String area() {
		// TODO Auto-generated method stub
		area = side * side;
		String result = "Area of Square is " + area;
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Square";
	}

}
