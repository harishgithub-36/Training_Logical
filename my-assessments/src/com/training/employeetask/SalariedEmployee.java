package com.training.employeetask;

public class SalariedEmployee extends Employee {
	private double Salary;

	public SalariedEmployee(String firstName, String lastName, int employeeid, String pincode, double Salary) {
		super(firstName, lastName, employeeid, pincode);
		this.setWeeklySalary(Salary);
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
