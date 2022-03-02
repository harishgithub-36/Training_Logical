package com.training.employeetask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HourlyEmployee extends Employee {
	private long hours;
	private long hourlyRate;
	private double Salary;
	private static Logger employeelogger = LogManager.getLogger(HourlyEmployee.class.getName());

	public HourlyEmployee(String firstName, String lastName, int employeeid, String pincode, long hours,
			long hourlyRate) {
		super(firstName, lastName, employeeid, pincode);
		this.setHours(hours);
		this.setHourlyRate(hourlyRate);
		employeelogger.info("Hourly Constructor Created");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		if (hours > 40) {
			Salary = 40 * hourlyRate;
			hours -= 40;
			Salary = hours * hourlyRate * 1.5;
		} else
			Salary = hours * hourlyRate;
		return Salary;
	}

//	@Override
//	public void details() {
//		System.out.println("The name of employee is " + firstName + lastName + " with id " + employeeid
//				+ " and his pincode is " + pincode);
//		// TODO Auto-generated method stub
//
//	}

	public long getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(long hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}

}
