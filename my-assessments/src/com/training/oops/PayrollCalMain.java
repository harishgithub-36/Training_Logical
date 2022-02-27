package com.training.oops;

import java.util.Scanner;

public class PayrollCalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the type of employee");
		String EmpType = s.nextLine();
		double fsal = 0;
		if (EmpType.equals("Salaried employee")) {
			System.out.println("Enter the weekly salary for employee");
			long salary = s.nextLong();
			fsal = salary;
		} else if (EmpType.equals("Hourly employee")) {
			System.out.println("Enter duration of hours employee worked");
			long hours = s.nextLong();
			System.out.println("Enter hourly rate");
			long hourlyRate = s.nextLong();
			if (hours > 40) {
				fsal = 40 * hourlyRate;
				hours -= 40;
				fsal = hours * hourlyRate * 1.5;
			} else
				fsal = hours * hourlyRate;

		} else if (EmpType.equals("CM")) {
			System.out.println("Enter the total sales of employee");
			long sales = s.nextLong();
			fsal = (sales * (0.15));
		} else if (EmpType.equals("BS")) {
			System.out.println("Enter the base salary of employee");
			long baseSalary = s.nextLong();
			long sales = s.nextLong();
			fsal = baseSalary + sales * (0.12);
			System.out.println(fsal);
			fsal += baseSalary * (0.1);
		}
		System.out.println(fsal);

	}

}
