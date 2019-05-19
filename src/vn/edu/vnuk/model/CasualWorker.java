package vn.edu.vnuk.model;

import java.util.Scanner;

public class CasualWorker extends Person {
	
	private int workDays;
	private float earningPerDay;
	private boolean isCreated;
	

	public int getWorkdays() {
		return workDays;
	}
	public void setWorkdays(int workdays) {
		this.workDays = workdays;
	}
	public float getEarningPerDay() {
		return earningPerDay;
	}
	public void setEarningPerDay(int earningPerDay) {
		this.earningPerDay = earningPerDay;
	}
	
	
	private CasualWorker(CasualWorkerBuilder builder) {
		
		this.isCreated = false;
		this.id = builder.id;
		this.type = builder.type;
		this.fullName = builder.fullName;
		this.yearOfBirth = builder.yearOfBirth;
		
		this.workDays = builder.workDays;
		this.earningPerDay = builder.earningPerDay;
	}

	public static class CasualWorkerBuilder {
	
			private int id;
			private int type;
			private String fullName;
			private int yearOfBirth;
			
			private int workDays;
			private float earningPerDay;
		
		
		public CasualWorkerBuilder (int id, int type) {
			this.id = id;
			this.type = type;
		
		}
	
		public CasualWorkerBuilder setFullName (String fullName) {
			this.fullName = fullName;
			return this;
		}
		
		public CasualWorkerBuilder setYearOfBirth (int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public CasualWorkerBuilder setWorkDays(int workDays) {
			this.workDays = workDays;
			return this;
		}
		
		public CasualWorkerBuilder setEarningPerDay(float earningPerDay) {
			this.earningPerDay = earningPerDay;
			return this;
		}
		
		public CasualWorker build(){
			return new CasualWorker(this);
		}
	 }
	@Override
	public String toString() {
		return "CasualWorker [workDays=" + workDays + ", earningPerDay=" + earningPerDay + ", fullName=" + fullName
				+ ", yearOfBirth=" + yearOfBirth + ", id=" + id + ", type=" + type + "]";
	}
	@Override
	public void input() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: " + ((isCreated) ? this.fullName : " ") + ":");
		this.fullName = sc.nextLine();
		
		System.out.println("Enter your year of birth: " + ((isCreated) ? this.yearOfBirth : " ") + ":");
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
	
		System.out.println("Enter your work days: " + ((isCreated) ? this.workDays : " ") + ":");
		this.workDays = Integer.parseInt(sc.nextLine());
	
		System.out.println("Enter your earning per day: " + ((isCreated) ? this.earningPerDay : " ") + ":");
		this.earningPerDay = Integer.parseInt(sc.nextLine());
		
		if (!isCreated) isCreated = true;
		
	}
	@Override
	public float getSalary() {
		float salary = workDays * earningPerDay;
		return salary;
	}
	
	}