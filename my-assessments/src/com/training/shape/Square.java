package com.training.shape;

public class Square extends Shape {
	private double side;
	private double area;

	Square(double side) {
		shapelogger.debug("Square Constructor is created Successfully");
		this.side = side;
	}

	public String area() {
		// TODO Auto-generated method stub
		area = side * side;
		String result = "Area of Square is " + area;
		return result;
	}

}
