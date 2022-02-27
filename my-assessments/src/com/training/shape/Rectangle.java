package com.training.shape;

public class Rectangle extends Shape {
	private int length;
	private int breadth;
	private double area;

	Rectangle(int length, int breadth) {
		shapelogger.debug("Rectangle Constructor is Created Successfully");
		this.length = length;
		this.breadth = breadth;

		// TODO Auto-generated constructor stub
	}

	public String area() {
		area = length * breadth;
		String result = "Area of Rectangle is " + area;
		return result;

	}

}
