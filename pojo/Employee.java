package com.mini.pojo;

public class Employee {
	
	private int empId;
	private String empName;
	private String designation;
	private double salary;
	
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String designation, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\n Employee Id=" + empId + "\nName=" + empName + " \nDesignation=" + designation + " \nSalary="
				+ salary + "";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	

}
