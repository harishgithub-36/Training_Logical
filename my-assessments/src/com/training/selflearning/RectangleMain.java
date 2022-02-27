package com.training.selflearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of Rectangles");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
//		System.out.println();
		List<Rectangle> li = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			System.out.println("Enter the name of Rectangle");
			String name = s.nextLine();

			Rectangle r = new Rectangle();
			r.setName(name);

			System.out.println("Enter the length of rectangle");

			int l = s.nextInt();
			s.nextLine();
			r.setLength(l);
			System.out.println("Enter the breadth of rectangle");
			int b = s.nextInt();
			s.nextLine();
			r.setBreadth(b);

			System.out.println("Enter the color of Rectangle");
			String color = s.nextLine();
			r.setColor(color);

			long area = l * b;
			r.setArea(area);
			li.add(r);

		}
		for (Rectangle r1 : li) {

			System.out.println("Circle " + r1.getName() + " with color " + r1.getColor() + " has area " + r1.getArea());
		}

	}

}
