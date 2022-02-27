package com.training.employeetask;

public class BaseSalariedCommissionEmployee extends Employee {
	private long Sales;
	private long baseSalary;
	private Double Salary;

	public BaseSalariedCommissionEmployee(String firstName, String lastName, int employeeid, String pincode,
			long baseSalary, long sales) {
		super(firstName, lastName, employeeid, pincode);
		this.setBaseSalary(baseSalary);
		this.setSales(sales);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double earnings() {
		Salary = baseSalary + Sales * (0.12);
		Salary += baseSalary * (0.1);
		// TODO Auto-generated method stub
		return Salary;
	}

//	@Override
//	public void details() {
//		System.out.println("The name of employee is " + firstName + lastName + " with id " + employeeid
//				+ " and his pincode is " + pincode);
//		// TODO Auto-generated method stub
//
//	}

	public long getSales() {
		return Sales;
	}

	public void setSales(long sales) {
		Sales = sales;
	}

	public long getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(long baseSalary) {
		this.baseSalary = baseSalary;
	}

}
