package vn.edu.vnuk.model;
import java.util.Scanner;

import vn.edu.vnuk.controller.Observer;
import vn.edu.vnuk.define.Define;


public class Lecturer extends Person implements Observer {
	
	private String homeTown;
	private String department;
	private String certificate;
	private int allowance;
	private int periodsInMonth;
	private float salaryRatio;
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
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getPeriodInMonth() {
		return periodsInMonth;
	}
	public void setPeriodInMonth(int periodsInMonth) {
		this.periodsInMonth = periodsInMonth;
	}
	public float getSalaryRatio() {
		return salaryRatio;
	}
	public void setSalaryRatio(float salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	public int getworkYears() {
		return workYears;
	}
	public void setworkYears(int workYears) {
		this.workYears = workYears;
	}
	public int getWorkYears() {
		return workYears;
	}
	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	private Lecturer(LecturerBuilder builder) {
			
			this.isCreated = false;
			this.id = builder.id;
			this.type = builder.type;
			this.fullName = builder.fullName;
			this.yearOfBirth = builder.yearOfBirth;
			
			this.homeTown = builder.homeTown;
			this.department = builder.department;
			this.certificate = builder.certificate;
			this.salaryRatio = builder.salaryRatio;
			this.allowance = builder.allowance;
			this.periodsInMonth = builder.periodsInMonth;
			this.workYears = builder.workYears;
			this.basicSalary = builder.basicSalary;
	}		

	public static class LecturerBuilder {
	
			
			private int id;
			private int type;
			private String fullName;
			private int yearOfBirth;
			
			private String homeTown;
			private String department;
			private String certificate;
			private float salaryRatio;
			private int allowance;
			private int periodsInMonth;
			private int workYears;
			private float basicSalary;
		
		public LecturerBuilder (int id, int type) {
			this.id = id;
			this.type = type;
		
		}
		
		public LecturerBuilder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}
		
		public LecturerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}

		public LecturerBuilder setHomeTown( String homeTown) {
			this.homeTown = homeTown;
			return this;
		}
		
		public LecturerBuilder setDepartment(String department){
			this.department = department;
			return this;
		}
		
		public LecturerBuilder setCertificate(String certificate){
			this.certificate = certificate;
			return this;
		}
		
		public LecturerBuilder setSalaryRatio(float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}	
		public LecturerBuilder setAllowance(int allowance) {
			this.allowance = allowance;
			return this;
		}
		
		
		public LecturerBuilder setPeriodsInMonth(int periodsInMonth) {
			this.periodsInMonth = periodsInMonth;
			return this;
		}
		
		public LecturerBuilder setWorkYears(int workYears) {
			this.workYears = workYears;
			return this;
		}
		
		public LecturerBuilder setBasicSalary(int basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Lecturer build(){
			return new Lecturer(this);
		}
	}
	
	@Override
	public String toString() {
		return "Lecturer [homeTown=" + homeTown + ", department=" + department + ", certificate=" + certificate
				+ ", allowance=" + allowance + ", periodsInMonth=" + periodsInMonth + ", salaryRatio=" + salaryRatio
				+ ", workYears=" + workYears + ", basicSalary=" + basicSalary + ", fullName=" + fullName
				+ ", yearOfBirth=" + yearOfBirth + ", id=" + id + ", type=" + type + "]";
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name " + ((isCreated) ? this.fullName : " ") + ":");
		this.fullName = sc.nextLine();

		System.out.println("Enter your year of birth " + ((isCreated) ? this.yearOfBirth : " ") + ":");
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter your home town: " + ((isCreated) ? this.homeTown : " ") + ":");
		this.homeTown = sc.nextLine();

		System.out.println("Enter your department: " + ((isCreated) ? this.department : " ") + ":");
		this.department = sc.nextLine();

		System.out.println("Enter your allowance: "  + ((isCreated) ? this.allowance : " ") + ":");
		this.allowance = Integer.parseInt(sc.nextLine());

		System.out.println("Enter your period in month: " + ((isCreated) ? this.periodsInMonth : " ") + ":");
		this.periodsInMonth = Integer.parseInt(sc.nextLine());

		System.out.println("Enter your salary ratio: " + ((isCreated) ? this.salaryRatio : " ") + ":");
		this.salaryRatio = Integer.parseInt(sc.nextLine());

		System.out.println("Enter your work year " + ((isCreated) ? this.workYears : " ") + ":");
		this.workYears = Integer.parseInt(sc.nextLine());
		
		basicSalary = Define.DEFAULT_BASIC_SALARY;
		
		System.out.println("Enter your cirtificate: " + ((isCreated) ? this.certificate : " ") +"\n" +
						   "1. Bachelor. \n" +
						   "2. Master. \n" +
				   		   "3. Doctor.");
		
		int selection = Integer.parseInt(sc.nextLine());
		switch (selection) {
		case Define.TYPE_OF_BACHELOR: {
			this.certificate = Define.CERTIFICATE_OF_BACHELOR;
			this.allowance = Define.ALLOWANCE_OF_BACHELOR;
			break;
		}
		case Define.TYPE_OF_MASTER: {
			this.certificate = Define.CERTIFICATE_OF_MASTER;
			this.allowance = Define.ALLOWANCE_OF_MASTER;
			break;
		}
		case Define.TYPE_OF_DOCTOR: {
			this.certificate = Define.CERTIFICATE_OF_DOCTOR;
			this.allowance = Define.ALLOWANCE_OF_DOCTOR;
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
		float salary = (salaryRatio * basicSalary) + allowance + (periodsInMonth * 45);
		return salary;
	}
	
}


	
