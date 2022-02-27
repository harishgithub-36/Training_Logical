package com.training.shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Shapes you want to enter");

		int n = s.nextInt();
		Shape sh = null;
		List<Shape> list = new ArrayList<>();
		HashMap<Integer, Shape> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			System.out.println("Please enter the code mentioned below for different shapes");
			System.out.println("1 for Circle");
			System.out.println("2 for Sqaure");
			System.out.println("3 for Rectangle");
			int choice = 0;
			try {
				choice = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e);
			}
			if (choice == 1) {
				System.out.println("Please enter radius of circle");
				int radius = s.nextInt();
				sh = new Circle(radius);
				list.add(sh);
			} else if (choice == 2) {
				System.out.println("Please enter side of square");
				int side = s.nextInt();
				sh = new Square(side);
				list.add(sh);
			} else if (choice == 3) {
				System.out.println("Please enter length of rectangle");
				int length = s.nextInt();
				System.out.println("Please enter breadth of rectangle");
				int breadth = s.nextInt();
				sh = new Rectangle(length, breadth);
				list.add(sh);
			}
			if (sh != null) {

				hash.put(choice, sh);
			}
		}
		System.out.println("Below are the codes for shapes");
		System.out.print("1 for Circle	");
		System.out.print("2 for Sqaure	");
		System.out.print("3 for Rectangle");
		System.out.println();

		int flag = 1;
		while (flag == 1) {
			System.out.println("Enter the shape code for which you want to see the details");
			int shapecode = s.nextInt();
			if (hash.containsKey(shapecode)) {
				Shape sh1 = hash.get(shapecode);
				System.out.println(sh1.area());
				flag = 0;
			} else {
				System.out.println("Please enter valid shapecode");
				continue;
			}
		}

	}

}
