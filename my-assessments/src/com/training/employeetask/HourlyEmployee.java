package com.training.employeetask;

public class HourlyEmployee extends Employee {
	private long hours;
	private long hourlyRate;
	private double Salary;

	public HourlyEmployee(String firstName, String lastName, int employeeid, String pincode, long hours,
			long hourlyRate) {
		super(firstName, lastName, employeeid, pincode);
		this.setHours(hours);
		this.setHourlyRate(hourlyRate);
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
