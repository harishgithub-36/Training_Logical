package com.training.employeetask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabaseRegistration {
	static Scanner s = new Scanner(System.in);
	static Connection myConn = null;
	static Statement myStmt = null;
	static ResultSet myRs = null;
	static PreparedStatement mypStmt = null;

	public static void registration() throws SQLException {
		// TODO Auto-generated method stub

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://192.168.0.156/harish_test", "root", "root");

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
					String query = "insert into employee(empfname,emplname,eid,pincode,payroll) values (?,?,?,?,?)";
					mypStmt = myConn.prepareStatement(query);
					mypStmt.setString(1, FirstName);
					mypStmt.setString(2, SecondName);
					mypStmt.setInt(3, employeeId);
					mypStmt.setString(4, PinCode);
					mypStmt.setDouble(5, emp.earnings());
					mypStmt.executeUpdate();
				}
				s.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}

	}

	public static void searchEmployeeDetails() throws SQLException {
		// TODO Auto-generated method stub
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://192.168.0.156/harish_test", "root", "root");

			System.out.println("Enter the name of the employee for which you want to see the details");
			String name = s.nextLine();
			System.out.println("Enter the id for the employee for which you want to see the details");
			int id = s.nextInt();
			String query = ("select * from employee where empfname=? and eid=?");
			mypStmt = myConn.prepareStatement(query);
			mypStmt.setString(1, name);
			mypStmt.setInt(2, id);
			myRs = mypStmt.executeQuery();

			display(myRs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
	}

	private static void display(ResultSet myRs) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("-----------------------");
		if (myRs.next() == false) {
			System.out.println("677890");
		} else {
			do {
				String fname = myRs.getString(1);
				String lname = myRs.getString(2);
				int id = myRs.getInt(3);
				int pincode = myRs.getInt(4);
				int payroll = myRs.getInt(5);
				System.out.println("The name of employee is " + fname + lname + " with id " + id
						+ " and his pincode is " + pincode + " having salary " + payroll);
			} while (myRs.next());
		}
		System.out.println("------------------------");
	}

	public static void search() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Enter 1 to get details of all employees		");
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
	}

	private static void getEmployeeDetails() throws SQLException {
		// TODO Auto-generated method stub
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://192.168.0.156/harish_test", "root", "root");

			String query = ("select * from employee");
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(query);

			display(myRs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
