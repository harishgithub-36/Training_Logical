package com.training.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of circles");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

//		System.out.println();
		List<Circle> li = new ArrayList<>();

		s.nextLine();
		for (int i = 0; i < n; i++) {

			System.out.println("Enter the name of circle");
			String name = s.nextLine();

			Circle c = new Circle();
			c.setName(name);

			System.out.println("Enter the radius of circle");

			int r = s.nextInt();
			s.nextLine();

			c.setRadius(r);
			System.out.println("Enter the color of circle");
			String color = s.nextLine();
			c.setColor(color);

			Double area = (Math.PI * r * r);
			c.setArea(area);
			li.add(c);
		}

		for (Circle c1 : li) {

			System.out.println("Circle " + c1.getName() + " with color " + c1.getColor() + " has area " + c1.getArea());
		}

	}

}
