package com.training.employeetask;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.training.employeetask.database.DatabaseRegistration;
import com.training.employeetask.filehandling.FileRegistration;

public class EmployeeMain {
	static Scanner s = new Scanner(System.in);
	static File file = new File("./resources/employee.txt");
	static ArrayList<Employee> al = new ArrayList<>();

	private static void registration() throws Exception {
		System.out.print("Enter 1 to register in file	");
		System.out.println("Enter 2 to register in database");
		int choiceReg = s.nextInt();
		try {
			System.out.println("Enter the number of employees");
			int n = s.nextInt();
			if (n < 0) {
				throw new InputMismatchException("Please enter a number greater than 0");
			}
			s.nextLine();
			Employee emp = null;
			for (int i = 0; i < n; i++) {
				System.out.println("Enter the first name of employee");
				String FirstName = s.nextLine();
				System.out.println("Enter the last name of employee");
				String SecondName = s.nextLine();
				System.out.println("Enter the employeeId");
				int employeeId = s.nextInt();
				System.out.println("Enter the employee pincode");
				String PinCode = s.next();

				System.out.println("Enter the choice for Employee");
				System.out.println("1 for Salaried Employee");
				System.out.println("2 for Hourly Employee");
				System.out.println("3 for Commission Employee");
				System.out.println("4 for Base-Salaried Commission Employee");
				int choice = s.nextInt();
				s.nextLine();

				if (choice == 1) {
					System.out.println("Enter the weekly salary for employee");
					double salary = s.nextLong();
					emp = new SalariedEmployee(FirstName, SecondName, employeeId, PinCode, salary);
				}

				else if (choice == 2) {
					System.out.println("Enter duration of hours employee worked");
					long hours = s.nextLong();
					System.out.println("Enter hourly rate");
					long hourlyRate = s.nextLong();
					emp = new HourlyEmployee(FirstName, SecondName, employeeId, PinCode, hours, hourlyRate);
				} else if (choice == 3) {
					System.out.println("Enter the total sales of employee");
					long sales = s.nextLong();
					emp = new CommissionEmployee(FirstName, SecondName, employeeId, PinCode, sales);
				} else if (choice == 4) {
					System.out.println("Enter the base salary of employee");
					long baseSalary = s.nextLong();
					System.out.println("Enter the sales");
					long sales = s.nextLong();
					emp = new BaseSalariedCommissionEmployee(FirstName, SecondName, employeeId, PinCode, baseSalary,
							sales);
				} else {
					System.out.println("Please enter a valid choice");
				}

				if (emp != null) {
					if (choiceReg == 1) {
						FileRegistration.registration(al, file, emp);
					} else if (choiceReg == 2) {
						DatabaseRegistration.registration(emp);
					} else {
						System.out.println("Wrong Choice Entered");
					}
				}
				s.nextLine();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void search() throws Exception {
		System.out.print("Enter 1 to search in file	");
		System.out.println("Enter 2 to search in database");
		int choice = s.nextInt();
		if (choice == 1) {

			FileRegistration.search(file, al);
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
