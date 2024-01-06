package com.mini.dao;

import com.mini.pojo.Employee;

public interface EmployeeDao {
	
	public boolean addEmployee(Employee e);
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(int empId);
	
	public Employee searchEmployeeById(int empID);
	public Employee searchEmployeeByName(String empName);
	public Employee[] showAllEmployees();
	
	
}
