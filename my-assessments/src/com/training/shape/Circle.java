package com.training.shape;

public class Circle extends Shape {
	private int radius;
	private double area;

	public Circle(int radius) {
		shapelogger.debug("Circle Constructor is Created Successfully");
		this.radius = radius;
	}

	public String area() {
		area = Math.PI * radius * radius;
		// TODO Auto-generated method stub
		String result = "Area of Circle is " + area;
		return result;
	}

}