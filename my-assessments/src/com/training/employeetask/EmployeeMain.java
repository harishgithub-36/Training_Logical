package com.training.employeetask;

import java.io.File;
import java.util.Scanner;

public class EmployeeMain {
	static Scanner s = new Scanner(System.in);
	static File file = new File("./resources/employee.txt");

	private static void registration() throws Exception {
		System.out.print("Enter 1 to register in file	");
		System.out.println("Enter 2 to register in database");
		int choice = s.nextInt();
		if (choice == 1) {
			FileRegistration.registration();
		} else if (choice == 2) {
			DatabaseRegistration.registration();
		} else {
			System.out.println("Wrong Choice Entered");
		}
	}

	private static void search() throws Exception {
		System.out.print("Enter 1 to search in file	");
		System.out.println("Enter 2 to search in database");
		int choice = s.nextInt();
		if (choice == 1) {
			FileRegistration.search();
		} else if (choice == 2) {
			DatabaseRegistration.search();
		} else {
			System.out.println("Wrong Choice Entered");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.print("Enter 1 to Register employee	");
		System.out.println("Enter 2 to Search Employee");
		int choice = s.nextInt();
		if (choice == 1)
			registration();
		else if (choice == 2)
			search();

	}

}
