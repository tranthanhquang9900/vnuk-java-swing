package vn.edu.vnuk.model;

import java.util.Scanner;

import vn.edu.vnuk.controller.Observer;
import vn.edu.vnuk.define.Define;

public class Staff extends Person implements Observer {
	
	private String homeTown;
	private String department;
	private float salaryRatio;
	private int allowance;
	private String position;
	private int workDays;
	private int workYears;
	private float basicSalary;
	private boolean isCreated;
	
	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(int salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public int getWorkYears() {
		return workYears;
	}

	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}

	public float getbasicSalary() {
		return basicSalary;
	}

	public void setbasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	

	private Staff(StaffBuilder builder) {
		
		this.isCreated = false;
		this.id = builder.id;
		this.type = builder.type;
		this.fullName = builder.fullName;
		this.yearOfBirth = builder.yearOfBirth;
		
		this.homeTown = builder.homeTown;
		this.department = builder.department;
		this.workDays = builder.workDays;
		this.allowance = builder.allowance;
		this.position = builder.position;
		this.salaryRatio = builder.salaryRatio;
		this.workYears = builder.workYears;
		this.basicSalary = builder.basicSalary;
	}		
	public static class StaffBuilder {
			
		private int id;
		private int type;
		private String fullName;
		private int yearOfBirth;
		
		private String homeTown;
		private String department;
		private float salaryRatio;
		private int allowance;
		private String position;
		private int workDays;
		private int workYears;
		private float basicSalary;
			
			public StaffBuilder (int id, int type) {
				this.id = id;
				this.type = type;
			
			}
			
			public StaffBuilder setFullName( String fullName) {
				this.fullName = fullName;
				return this;
			}
			
			public StaffBuilder setYearOfBirth( int yearOfBirth) {
				this.yearOfBirth = yearOfBirth;
				return this;
			}

			public StaffBuilder setHomeTown( String homeTown) {
				this.homeTown = homeTown;
				return this;
			}
			
			public StaffBuilder setDepartment(String department){
				this.department = department;
				return this;
			}
			
			public StaffBuilder setSalaryRatio(float salaryRatio) {
				this.salaryRatio = salaryRatio;
				return this;
			}	
			public StaffBuilder setAllowance(int allowance) {
				this.allowance = allowance;
				return this;
			}
			
			public StaffBuilder setPosition(String position) {
				this.position = position;
				return this;
			}
			
			public StaffBuilder setWorkDays(int workDays) {
				this.workDays = workDays;
				return this;
			}
			
			public StaffBuilder setWorkYears(int workYears) {
				this.workYears = workYears;
				return this;
			}
			
			public StaffBuilder setbasicSalary(float basicSalary) {
				this.basicSalary = basicSalary;
				return this;
			}
			
			public Staff build(){
				return new Staff(this);
			}
	}

	@Override
		public String toString() {
			return "Staff [homeTown=" + homeTown + ", department=" + department + ", salaryRatio=" + salaryRatio
					+ ", allowance=" + allowance + ", position=" + position + ", workDays=" + workDays + ", workYears="
					+ workYears + ", basicSalary=" + basicSalary + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth
					+ ", id=" + id + ", type=" + type + "]";
		}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your fullname :" + ((isCreated) ? this.fullName : " ") + ":");
		this.fullName = sc.nextLine();
	
		System.out.println("Enter your year of birth: " + ((isCreated) ? this.yearOfBirth : " ") + ":");
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
	
		System.out.println("Enter your home town: " + ((isCreated) ? this.homeTown : " ") + ":");
		this.homeTown = sc.nextLine();
	
		System.out.println("Enter your department: " + ((isCreated) ? this.department : " ") + ":");
		this.department = sc.nextLine();
	
		System.out.println("Enter your work days: " + ((isCreated) ? this.workDays : " ") + ":");
		this.workDays = Integer.parseInt(sc.nextLine());
	
		System.out.println("Enter your allowance: " + ((isCreated) ? this.allowance : " ") + ":");
		this.allowance = Integer.parseInt(sc.nextLine());
	
		System.out.println("Enter your salary ratio: " + ((isCreated) ? this.salaryRatio : " ") + ":");
		this.salaryRatio = Integer.parseInt(sc.nextLine());
		
		basicSalary = Define.DEFAULT_BASIC_SALARY;
		
		System.out.println("Choose your position " + ((isCreated) ? this.position : " ") + "\n" +
		   		   "1. Chief \n" +
		           "2. Deputy \n" +
		   	       "3. Employee");
		
		int selection = Integer.parseInt(sc.nextLine());
	
		switch (selection) {
		case Define.TYPE_OF_CHIEF: {
			this.position = Define.POSITION_OF_CHIEF;
			this.allowance = Define.ALLOWANCE_OF_CHIEF;
			break;
		}
		case Define.TYPE_OF_DEPUTY: {
			this.position = Define.POSITION_OF_DEPUTY;
			this.allowance = Define.ALLOWANCE_OF_DEPUTY;
			break;
		}
		case Define.TYPE_OF_EMPLOYEE: {
			this.position = Define.POSITION_OF_EMPLOYEE;
			this.allowance = Define.ALLOWANCE_OF_EMPLOYEE;
			break;
		}
		}
		
		if (!isCreated) isCreated = true;
	}
	
	
	@Override 
	public void update (float basicSalary) {
	    this.basicSalary = basicSalary;
	}

	@Override
	public float getSalary() {
		float salary = (salaryRatio * basicSalary) + allowance + (workDays * 30);
		return salary;
	}
		
	}
