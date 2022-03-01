package com.training.employeetask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class EmployeeMain {
	static Scanner s = new Scanner(System.in);
	static HashMap<String, Employee> hash = new HashMap<>();
	static ArrayList<Employee> al = new ArrayList<>();
	static ListIterator li = null;
	static File file = new File("./resources/employee.txt");
	static ObjectOutputStream oos = null;
	static ObjectInputStream ois = null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of employees");
		try {
			int n = s.nextInt();
			if (n < 0) {
				throw new InputMismatchException("Please enter a number greater than 0");
			}
			s.nextLine();
			Employee emp = null;

			if (file.isFile()) {
				ois = new ObjectInputStream(new FileInputStream(file));
				al = (ArrayList<Employee>) ois.readObject();
				ois.close();
			}

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
					al.add(emp);
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					hash.put(FirstName, emp);
				}
				s.nextLine();
			}

			System.out.println("Enter 1 to get Employee details");
			System.out.println("Enter 2 to get the details of a particular employee");
			int choice1 = s.nextInt();
			int flag = 1;
			while (flag == 1) {
				if (choice1 == 1) {
					getEmployeeDetails();
					flag = 0;
				} else if (choice1 == 2) {
					searchEmployeeDetails();
					flag = 0;
				} else {
					System.out.println("Invalid code please enter correct code");
				}
			}
//			System.out.println("Enter the firstname of employee for which you want to see payroll and details");
//			String name = s.nextLine();
//			if (hash.containsKey(name)) {
//				EmployeeDetails emd = new EmployeeDetails(hash.get(name));
//				emd.details();
//			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void searchEmployeeDetails() {
		// TODO Auto-generated method stub
		if (file.isFile()) {
			System.out.println("Enter the id of employee for which you want to see payroll and details");
			boolean found = false;
			int id = s.nextInt();
			li = al.listIterator();
			while (li.hasNext()) {
				Employee e = (Employee) li.next();
				if (e.employeeid == id) {
					System.out.println(e);
					found = true;
				}
			}
			if (!found)
				System.out.println("Record not found");
		} else {
			System.out.println("File not exists");
		}
	}

	public static void getEmployeeDetails() {
		if (file.isFile()) {
			System.out.println("Enter the firstname of employee for which you want to see payroll and details");
//		String name = s.nextLine();
			li = al.listIterator();
			System.out.println("------------------------------");
			while (li.hasNext()) {
				System.out.println(li.next());
			}
		} else {
			System.out.println("File not exists");
		}
		System.out.println("-----------------------------------");

	}

}
