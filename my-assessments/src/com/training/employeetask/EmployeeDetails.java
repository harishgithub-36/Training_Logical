package com.training.employeetask;

public class EmployeeDetails {
	private Employee ed;

	public EmployeeDetails(Employee emp1) {
		ed = emp1;
		// TODO Auto-generated constructor stub
	}

	public void details() {
		System.out.println("The name of employee is " + ed.firstName + ed.lastName + " with id " + ed.employeeid
				+ " and his pincode is " + ed.pincode + " having salary " + ed.earnings());
	}

}
