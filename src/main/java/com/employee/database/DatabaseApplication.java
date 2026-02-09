package com.employee.database;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.employee.database.model.EmployeeRegisterar;
import com.employee.database.repo.RepositLayer;

@SpringBootApplication
public class DatabaseApplication {

	public static String getAction(){
		Scanner scan = new Scanner(System.in);
		String action;
		System.out.print("Enter your action: ");
		while(true){
			action = scan.nextLine();
			if(action.equals("enter") || action.equals("show")){
				return action;
			}
			else if(action.equals("exit")){
				return action;
			}
			System.out.println("Enter valid action!");
		}
	}

	public static void generateArt(){
		System.out.println("""
                                   +--------------------------------------------------+\r
                                   |                 EMPLOYEE DATABASE                |\r
                                   +--------------------------------------------------+""" //
                //
                );
		System.out.println("Actions to do:\n1)enter\n2)show\n3)exit");
	}

	public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Forces the output to be written immediately
    }

	public static String getStatus(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Status: ");
		String status = scan.nextLine();
		return status;
	}

	public static int getSalary(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Salary: ");
		int salary = scan.nextInt();
		return salary;
	}

	public static int getInt(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter ID: ");
		int id = scan.nextInt();
		return id;
	}

	public static String getName(){
		Scanner scan = new Scanner(System.in);
		System.out.print ("Enter name: ");
		String name = scan.nextLine();
		return name;
	}

	public static void main(String[] args) {
		
		ApplicationContext cntxt = SpringApplication.run(DatabaseApplication.class, args);
		EmployeeRegisterar employData = cntxt.getBean(EmployeeRegisterar.class);
		RepositLayer repoLayer = cntxt.getBean(RepositLayer.class);
		Scanner scan = new Scanner(System.in);
		while(true){
			clearScreen();
			generateArt();
			String action = getAction();
			if(action.equals("enter")){
				System.out.println("Entering");
				// enter data
				employData.setEmployee_id(getInt());
				employData.setEmployee_name(getName());
				employData.setEmployee_salary(getSalary());
				employData.setEmployee_on_site(getStatus());
				repoLayer.Save(employData);
				System.out.println("Press Enter vv");
				scan.nextLine();
			}
			else if(action.equals("show")){
				System.out.println("Showing");
				System.out.println(repoLayer.getRows());
				System.out.println("Press Enter vv");
				scan.nextLine();
				}
			else{
				System.out.println("exiting");
				break;
			}
		}
	}

}
