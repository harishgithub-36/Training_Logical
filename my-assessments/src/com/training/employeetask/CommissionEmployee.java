package com.training.employeetask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommissionEmployee extends Employee {
	private double Salary;
	private long Sales;
	private static Logger employeelogger = LogManager.getLogger(CommissionEmployee.class.getName());

	public CommissionEmployee(String firstName, String lastName, int employeeid, String pincode, Long Sales) {
		super(firstName, lastName, employeeid, pincode);
		this.setSales(Sales);
		employeelogger.info("CommisionEmployee Constructor Created");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double earnings() {
		Salary = (Sales * 0.15);
		// TODO Auto-generated method stub
		return Salary;
	}

//	@Override
//	public void details() {
//		// TODO Auto-generated method stub
//		System.out.println("The name of employee is " + firstName + lastName + " with id " + employeeid
//				+ " and his pincode is " + pincode);
//
//	}

	public long getSales() {
		return Sales;
	}

	public void setSales(long Sales) {
		this.Sales = Sales;
	}

}
