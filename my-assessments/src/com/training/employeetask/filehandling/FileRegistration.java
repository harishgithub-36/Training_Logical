package com.training.employeetask.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import com.training.employeetask.Employee;

public class FileRegistration {
	static Scanner s = new Scanner(System.in);

	public static void registration(ArrayList<Employee> al, File file, Employee emp)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>) ois.readObject();
			ois.close();
		}

		if (emp != null) {
			al.add(emp);
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
		}

	}

	public static void search(File file, ArrayList<Employee> al) throws Exception {
		// TODO Auto-generated method stub

		System.out.print("Enter 1 to get details of all employees		");
		System.out.println("Enter 2 to get the details of a particular employee");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		int choice1 = s.nextInt();
		int flag = 1;

		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>) ois.readObject();
			ois.close();
		}

		while (flag == 1) {
			if (choice1 == 1) {
				getEmployeeDetails(file, al);
				flag = 0;
			} else if (choice1 == 2) {
				searchEmployeeDetails(file, al);
				flag = 0;
			} else {
				System.out.println("Invalid code please enter correct code");
			}
		}
	}

	public static void searchEmployeeDetails(File file, ArrayList<Employee> al) {
		// TODO Auto-generated method stub
		ListIterator li = null;
		if (file.isFile()) {
			System.out.println("Enter the id of employee for which you want to see payroll and details");
			boolean found = false;
			int id = s.nextInt();
			li = al.listIterator();
			System.out.println("-------------------------");
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
		System.out.println("--------------------------");
	}

	public static void getEmployeeDetails(File file, ArrayList<Employee> al) {
		ListIterator li = null;
		if (file.isFile()) {
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
