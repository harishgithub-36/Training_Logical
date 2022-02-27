package com.training.employeetask;

public abstract class Employee {
	protected String firstName;
	protected String lastName;
	protected int employeeid;
	protected String pincode;

	public Employee(String firstName, String lastName, int employeeid, String pincode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setEmployeeid(employeeid);
		this.pincode = pincode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public abstract double earnings();

}
