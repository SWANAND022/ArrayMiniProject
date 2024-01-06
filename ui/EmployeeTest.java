package com.mini.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.mini.dao.EmployeeDaoImpl;
import com.mini.pojo.Employee;
import com.mini.pojo.User;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 boolean exit= false;
		 boolean flag;
		 int empId = 101;
		 String empName;
		 String designation;
		 double salary;
		 String choice;
	     boolean loggedIn = false;
			
		 
		 Employee e = null;
		 EmployeeDaoImpl eimpl = new EmployeeDaoImpl();
		 Employee[] emplist =new Employee[50];  //TODO:- here check size correct or not
	 	 Scanner sc = new Scanner(System.in);
		
		
		
        User adminUser = new User("admin", "admin123");
		
        
		System.out.println("********** WELCOME TO SOCIAL EMPLOYEE ************");
		
        while (!loggedIn) {
            System.out.print("Enter your username: ");
            String username = sc.nextLine();
            System.out.print("Enter your password: ");
            String password = sc.nextLine();

            if (adminUser.getUsername().equals(username) && adminUser.getPassword().equals(password)) {
                loggedIn = true;
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
		
        
        while (!exit) {
        	
        	while (exit == false) {
    			System.out.println("Please enter the number as given in option...");
    			System.out.println("1 -------> Register Employee");
    			System.out.println("2 -------> Show All Employee");
    			System.out.println("3 -------> Search Employee ");
    			System.out.println("4 -------> Update Employee");
    			System.out.println("5 -------> Delete Employee Profile");
    			System.out.println("6 -------> Exit");

    			int option = sc.nextInt();
    			sc.nextLine();
    			
    			switch(option){
    			case 1: 
    				System.out.print("Enter your name:");
    				empName= sc.nextLine();

    				System.out.print("Enter your Designation:");
    				designation = sc.nextLine();
    				
    				System.out.print("Enter your Salary:");
    				salary = sc.nextDouble();
    				sc.nextLine();
    				
    				empId+=12;
    				
    				e = new Employee(empId, empName, designation, salary);
    				
    				flag = eimpl.addEmployee(e);
    				
    				if( flag ) {
    					System.out.println("Employe registered successfully");
    					System.out.println(Arrays.toString(eimpl.showAllEmployees()));
    					}
    				else 
    					System.err.println("Error While adding employee!!");
    				
    				break;
    				
    			case 2:
    				
    				//System.out.println(Arrays.toString(eimpl.showAllEmployees()));
    				emplist=eimpl.showAllEmployees();
    			    for(Employee e1:  emplist) {
    			    	
    			    	if(e1!=null)
    			    		System.out.println(e1);
    			    	
    			    }
    			    System.out.println("_______________");
    				
    				break;
    				
    			case 3:
    				
    				System.out.println("You can search Employee Based On Their Id and Name:- ");
    				System.out.println("1.Search Employee By Id");
    				System.out.println("2.Search Employee By Name");
    				
    				int searchemp=sc.nextInt();
    				sc.nextLine();
    				
    				 if (searchemp == 1) {
    				        System.out.print("Enter Employee ID: ");
    				        int id = sc.nextInt();
    				        sc.nextLine();
    				        
    				        e = eimpl.searchEmployeeById(id);
    				        
    				        if (e != null) {
    				            System.out.println("The employee found with the given ID:\n" + e);
    				        } else {
    				            System.out.println("Sorry, we could not find any employee with this ID.");
    				        }
    				    } 
    				 else if (searchemp == 2) {
    				        System.out.print("Enter Employee Name: ");
    				        String name = sc.nextLine();
    				        
    				        e = eimpl.searchEmployeeByName(name);
    				        
    				        if (e != null)
    				        {
    				            System.out.println("The employee found with the given name:\n" + e);
    				        } 
    				        else
    				        {
    				            System.out.println("Sorry, we could not find any employee with this name.");
    				        }
    				    } else 
    				    {
    				        System.out.println("You select the Wrong Option, Try again..");
    				    }
    				
    				
    				break;
    				
    				
    			case 4:
    				
    				System.out.println("Enter the id to be update: ");
    				int id =sc.nextInt();
    				sc.nextLine();
    				
    				e=eimpl.searchEmployeeById(id);
    				
    				if (e!=null) {
    					
    					System.out.println("**** The Profile ****");
    					System.out.println(e);
    					
    					System.out.println("are you sure you want to update this profile?");
    					System.out.print("Answer is yes or no : ");
    					choice = sc.next();
    					sc.nextLine();
    					
    					if(choice.equalsIgnoreCase("yes")) {
    						
    					
    						System.out.println("\nWhat you want to update : "
    								+ "\n1.Name \n2.Designation \n3.Salary");
    						
    						 int updateemp = sc.nextInt();
    					        sc.nextLine();
    					        
    					        switch (updateemp) {
    					            case 1:
    					                System.out.println("Enter the new name: ");
    					                empName = sc.nextLine();
    					                e.setEmpName(empName);
    					                break;
    					            case 2:
    					                System.out.println("Enter the new designation: ");
    					                designation = sc.nextLine();
    					                e.setDesignation(designation);
    					                break;
    					            case 3:
    					                System.out.println("Enter the new salary: ");
    					                salary = sc.nextDouble();
    					                sc.nextLine();
    					                e.setSalary(salary);
    					                break;
    					            default:
    					                System.out.println("Sorry! You Entered Incoreect Input");
    					                break;
    					        }
    					        
    					        if (updateemp >= 1 && updateemp <= 3) {
    					            flag = eimpl.updateEmployee(e);
    					        
    						
    						if(flag) 
    							System.out.println("Employee updated successfully");
    						
    						else 
    							System.out.println("Errorwhile updating the wmployee");
    						
    					}
    					else 
    						System.out.println("no problem.Please continue browsing!..");
    				}
    				else
    					System.out.println("No employee found with this id");
    				}
    				
    				
    				break;
    				
    				
    			case 5:
    				
    				System.out.println("Enter the id of Employee to be deleted : ");
    		     	id=sc.nextInt();
    				sc.nextLine();
    				
    				boolean e1 =  eimpl.deleteEmployee(id);
    				
    				if (e1) {
                        System.out.println("Employee deleted successfully.");
                        
                    } else {
                        System.err.println("Sorry we could not delete any employee with this id.");
                    }
    				
    				
    				break;
    				
    			case 6:
    				exit = true;
    				System.out.println("Thankyou For Visiting");
    				break;
    			}
    					
    		}

        	
        	
        }
        
        
		
		
	}

}
