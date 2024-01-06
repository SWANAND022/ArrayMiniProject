package com.mini.dao;

import com.mini.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Employee[] empList = new Employee[50];
	int index =0;
	
	

	
	@Override
	public boolean addEmployee(Employee e) {
		
		if(index < 50) {
			empList[index]=e;
			index++;
			
		return true;
		}
		
		
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<empList.length;i++) {
			
			if(empList[i].getEmpId()== e.getEmpId()) {
				empList[i]=e;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < empList.length; i++) {
            if (empList[i].getEmpId() == empId) {
                empList[i] = null;
                return true;
            }
        }
		return false;
	}

	@Override
	public Employee searchEmployeeById(int empID) {
		// TODO Auto-generated method stub
		
		for(Employee emp :empList) {
			
			if(emp!=null) {
				int id = emp.getEmpId();
				if(id == empID) {
					return emp;
				}
			}
		}
		return null;
	}

	@Override
	public Employee[] showAllEmployees() {
		return empList;
	}

	@Override
	public Employee searchEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		
	    for (Employee emp : empList) {
	    	if (emp != null) {
	    		String name = emp.getEmpName();
	    		if (name != null && name.equals(empName)) {
	    			return emp;
	    			}
	    		 }                                  
	    	 }
	   return null;
	   }
}
