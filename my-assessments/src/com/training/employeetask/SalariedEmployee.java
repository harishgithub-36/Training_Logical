package com.training.employeetask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalariedEmployee extends Employee {
	private double Salary;
	private static Logger employeelogger = LogManager.getLogger(SalariedEmployee.class.getName());

	public SalariedEmployee(String firstName, String lastName, int employeeid, String pincode, double Salary) {
		super(firstName, lastName, employeeid, pincode);
		this.setWeeklySalary(Salary);
		employeelogger.info("SalariedEMployee Constructor Created Successfully");
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return Salary;
	}

	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary >= 0.0) {
			this.Salary = weeklySalary;
		}
	}

//	public void details() {
//		System.out.println("The name of employee is " + firstName + lastName + " with id " + employeeid
//				+ " and his pincode is " + pincode);
//	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub

		return getSalary();
	}

}
