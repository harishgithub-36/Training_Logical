package com.training.employeetask;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of employees");

		try {
			int n = s.nextInt();
			if (n < 0) {
				throw new InputMismatchException("Please enter a number greater than 0");
			}
			s.nextLine();
			Employee emp = null;
			HashMap<String, Employee> hash = new HashMap<>();
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
					hash.put(FirstName, emp);
				}
				s.nextLine();
			}

			System.out.println("Enter the firstname of employee for which you want to see payroll and details");

			String name = s.nextLine();
			if (hash.containsKey(name)) {
				EmployeeDetails emd = new EmployeeDetails(hash.get(name));
				emd.details();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
