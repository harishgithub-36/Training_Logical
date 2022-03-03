package com.training.employeetask.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.training.employeetask.Employee;

public class DatabaseRegistration {
	static Scanner s = new Scanner(System.in);

	public static void registration(Employee emp) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Connection myConn = null;
			PreparedStatement mypStmt = null;
			myConn = Driver.createConnection();
			ResultSet myRs = null;
			if (emp != null) {
				String checkquery = ("select * from employee where eid=?");
				mypStmt = myConn.prepareStatement(checkquery);
				mypStmt.setInt(1, emp.employeeid);
				myRs = mypStmt.executeQuery();
				if (myRs.next() == true) {
					System.out.println("Record with given id is already present");
				} else {
					String query = "insert into employee(empfname,emplname,eid,pincode,payroll) values (?,?,?,?,?)";
					mypStmt = myConn.prepareStatement(query);
					mypStmt.setString(1, emp.firstName);
					mypStmt.setString(2, emp.lastName);
					mypStmt.setInt(3, emp.employeeid);
					mypStmt.setString(4, emp.pincode);
					mypStmt.setDouble(5, emp.earnings());
					mypStmt.executeUpdate();

				}
			}

			if (mypStmt != null) {
				mypStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
			if (myRs != null) {
				myRs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void searchEmployeeDetails() throws SQLException {
		// TODO Auto-generated method stub
		try {
			Connection myConn = null;
			PreparedStatement mypStmt = null;
			ResultSet myRs = null;
			myConn = Driver.createConnection();
			System.out.println("Enter the firstname of the employee for which you want to see the details");
			s.nextLine();
			String name = s.nextLine();
			System.out.println("Enter the id for the employee for which you want to see the details");
			int id = s.nextInt();
			String query = ("select * from employee where empfname=? and eid=?");
			mypStmt = myConn.prepareStatement(query);
			mypStmt.setString(1, name);
			mypStmt.setInt(2, id);
			myRs = mypStmt.executeQuery();

			display(myRs);
			if (myRs != null) {
				myRs.close();
			}
			if (mypStmt != null) {
				mypStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		
	}

	private static void display(ResultSet myRs) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("-------------------------------------------------------");
		if (myRs.next() == false) {
			System.out.println("Record with given credentials is not present");
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
		System.out.println("---------------------------------------------------------");
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
			Connection myConn = null;
			PreparedStatement mypStmt = null;
			ResultSet myRs = null;
			Statement myStmt = null;
			myConn = Driver.createConnection();

			String query = ("select * from employee");
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(query);

			display(myRs);
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
