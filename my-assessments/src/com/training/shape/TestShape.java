package com.training.shape;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Shapes you want to enter");
		try {
			int n = s.nextInt();
			Shape sh = null;
			HashMap<Integer, Shape> hash = new HashMap<>();
			HashMap<String, Shape> hashi = new HashMap<>();
			int i = 0;
			while (i < n) {
				System.out.println("Please enter the code mentioned below for different shapes");
				System.out.print("1 for Circle	");
				System.out.print("2 for Sqaure	");
				System.out.println("3 for Rectangle");
				int choice = 0;
				String id = "";
				try {
					choice = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(e);
				}
				if (choice == 1) {
					System.out.println("Please enter radius of circle");
					int radius = s.nextInt();
					System.out.println("Please enter the id for circle");
					id = s.next();
					if (!hashi.containsKey(id))
						sh = new Circle(radius, id);
					else {
						System.out.println("Circle with given id already Exists");
						continue;
					}

				} else if (choice == 2) {
					System.out.println("Please enter side of square");
					int side = s.nextInt();
					System.out.println("Please enter the id for square");
					id = s.next();
					if (!hashi.containsKey(id))
						sh = new Square(side, id);
					else {
						System.out.println("Square with given id already exits");
						continue;
					}

				} else if (choice == 3) {
					System.out.println("Please enter length of rectangle");
					int length = s.nextInt();
					System.out.println("Please enter breadth of rectangle");
					int breadth = s.nextInt();
					System.out.println("Please enter the id for rectangle");
					id = s.next();
					if (!hashi.containsKey(id))
						sh = new Rectangle(length, breadth, id);
					else {
						System.out.println("Rectangle with given id already exits");
						continue;
					}
				}
				if (sh != null) {
					hashi.put(id, sh);
					hash.put(choice, sh);
				}
				i++;
			}

			System.out.println("Below are the codes for shapes");
			System.out.print("1 for Circle	");
			System.out.print("2 for Sqaure	");
			System.out.print("3 for Rectangle");
			System.out.println();
			int shapecode = s.nextInt();
			int flag = 1;

			while (flag == 1) {
//				System.out.println("Below are the codes for shapes");
//				System.out.print("1 for Circle	");
//				System.out.print("2 for Sqaure	");
//				System.out.print("3 for Rectangle");
//				System.out.println();
//				System.out.println("Enter the shape code for which you want to see the details");
//				int shapecode = s.nextInt();

				if (hash.containsKey(shapecode)) {
					System.out.println("Enter the id for " + hash.get(shapecode).getName());
					String id = s.next();
					if (hashi.containsKey(id)) {
						Shape sh1 = hashi.get(id);
						System.out.println("-----------" + sh1.area() + "--------------");
						flag = 0;
					} else {
						System.out.println(hash.get(shapecode).getName() + " with " + id + " does not exists");
					}

				} else {
					System.out.println("Please enter valid shapecode");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
