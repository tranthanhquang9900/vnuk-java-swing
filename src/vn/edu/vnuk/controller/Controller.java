package vn.edu.vnuk.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import vn.edu.vnuk.model.Lecturer;
import vn.edu.vnuk.model.Person;
import vn.edu.vnuk.model.Staff;

public class Controller {
	public static void arrayList() {
		ArrayList<String> str = new ArrayList<String>();
	}

public static void menuOne() {
	System.out.println(
			   "[1.1] - Add new staff at the end of the list \n" +
			   "[1.2] - Add new staff on the head of the list \n" +
			   "[1.3] - Add new staff after k position  \n" +
			   "[1.4] - Add new staff at the end of the list from staff.txt \n" +	
			   "[1.5] - Add new casual worker from labor.txt \n" +
			   "[1.6] - Back to main Menu \n");
	
	int value = inputSelection(1, 6);
	switch (value) {
	
		case 1: {
			
			switch (selectTypeOfEmployee()) {
			
				case Define.TYPE_OF_LECTURER: {
					 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
					 lecturer.input();
					 Define.persons.add(lecturer);
					 break;
				}
			
				case Define.TYPE_OF_STAFF: {
					Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
					staff.input();
					Define.persons.add(staff);
					break;
				}
			
				case Define.TYPE_OF_CASUAL_WORKER: {
					CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
					casualWorker.input();
					Define.persons.add(casualWorker);
					break;
				}
			}
			break;
		}
	
		case 2: {
			switch (selectTypeOfEmployee()) {
				case Define.TYPE_OF_LECTURER: {
					 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
					 lecturer.input();
					 Define.persons.add(0, lecturer);
					 break;
				}
				
				case Define.TYPE_OF_STAFF: {
					Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
					staff.input();
					Define.persons.add(0, staff);
					break;
				}
				
				case Define.TYPE_OF_CASUAL_WORKER: {
					CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
					casualWorker.input();
					Define.persons.add(0, casualWorker);
					break;
				}
			}
			break;
		}
	
		case 3: {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter k position: ");
			int k = sc.nextInt();
			
			switch (selectTypeOfEmployee()) {
			
				case Define.TYPE_OF_LECTURER: {
					 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
					 lecturer.input();
					 Define.persons.add(k - 1, lecturer);
					 break;
				}
				
				case Define.TYPE_OF_STAFF: {
					Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
					staff.input();
					Define.persons.add(k - 1, staff);
					break;
				}
				
				case Define.TYPE_OF_CASUAL_WORKER: {
					CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
					casualWorker.input();
					Define.persons.add(k - 1, casualWorker);
					break;
				}
			}
			break;
		}
		case 4: {
			
			Scanner sc = null;
			try {
				sc = new Scanner(new File("staff.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int numberOfStaffs = Integer.parseInt(sc.nextLine());
			int type;
			float salaryRatio;
			int yearOfBirth,allowance = 0,workDays,workYears,periodsInMonth;
			String fullName, homeTown, department, position,certificate;
			
				for(int index = 0; index < numberOfStaffs; index++) {
					type = Integer.parseInt(sc.nextLine());
					yearOfBirth = Integer.parseInt(sc.nextLine());
					fullName = sc.nextLine();
					homeTown = sc.nextLine();
					department = sc.nextLine();
					workYears = Integer.parseInt(sc.nextLine());
					salaryRatio = Float.parseFloat(sc.nextLine());
					
						if (type == Define.TYPE_OF_STAFF) {
							position = sc.nextLine();
							workDays = Integer.parseInt(sc.nextLine());
							
							Staff newStaff = new Staff.StaffBuilder(Define.latestId, Define.TYPE_OF_STAFF)
									.setYearOfBirth(yearOfBirth)
									.setFullName(fullName)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setWorkYears(workYears)
									.setSalaryRatio(salaryRatio)
									.setPosition(position)
									.setWorkDays(workDays)
									.build();
							
						}
						else {
							certificate = sc.nextLine();
							periodsInMonth = Integer.parseInt(sc.nextLine());
							
							Lecturer newLecturer = new Lecturer.LecturerBuilder (Define.latestId, Define.TYPE_OF_LECTURER)
									.setFullName(fullName)
									.setYearOfBirth(yearOfBirth)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setWorkYears(workYears)
									.setSalaryRatio(salaryRatio)
									.setCertificate(certificate)
									.setPeriodsInMonth(periodsInMonth)
									.build();
						}
				}
		}
		case 5: {
			Scanner sc = null;
			try {
				sc = new Scanner(new File("labor.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int numberOfCasualWorkers = Integer.parseInt(sc.nextLine());
			int yearOfBirth, workDays;
			float earningPerDay;
			String fullName;
			
			for (int index = 0; index < numberOfCasualWorkers; index++) {
				fullName = sc.nextLine();
				yearOfBirth = Integer.parseInt(sc.nextLine());
				workDays = Integer.parseInt(sc.nextLine());
				earningPerDay = Float.parseFloat(sc.nextLine());
				
				CasualWorker newCasualWorker = new CasualWorker.CasualWorkerBuilder(Define.latestId, Define.TYPE_OF_CASUAL_WORKER)
						.setFullName(fullName)
						.setWorkDays(workDays)
						.setYearOfBirth(yearOfBirth)
						.setEarningPerDay(earningPerDay)
						.build();
				
				Define.persons.add(newCasualWorker);
			}

			break;
		}
		
		case 6: {
			return;
		}
		}
	}

public static void menuTwo() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter employee's number: ");
	
	int value = Integer.parseInt(sc.nextLine());
	
	ArrayList<Person> persons = new ArrayList<Person>();
	persons = Define.persons;
	
		for(int i = 0; i< Define.persons.size(); i++) {
			if (i == value) {
				persons.get(i).input();
			} else {
				System.out.println("Cannot found user!");
			}
		}
	
	return;
}

public static void menuThree() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the emplyee's number: ");
	
	int  value = Integer.parseInt(sc.nextLine()); 
	
	ArrayList<Person> persons = new ArrayList<Person>();
	persons = Define.persons;
	  
	  for ( int i = 0; i < Define.persons.size(); i++) {
		  
		  if(i == value) {
			  persons.get(i).input();	  
		  }
		  
		  else {
			  System.out.println("Can't find user!");
		  }
	  }	  	  	  
}

public static void menuFour() {
	System.out.println(
					   "[4.1] - Show current list \n" +
					   "[4.2] - Show list increase by salary  \n" +
					   "[4.3] - Show list by alphabet \n" +
					   "[4.4] - Search cadres and display information \n" +
					   "[4.5] - Show list of staff by year of birth \n" +
					   "[4.6] - Exit");
	int value = inputSelection(1, 6);
		switch (value) {
		
			case 1: {
				showListPerson(Define.persons);
				break;
			}
			
			case 2: {
				ArrayList<Person> persons = new ArrayList<Person>();
				persons = Define.persons;
				
				for (int i = 0; i < Define.persons.size() - 1; i++) {
					for (int j = i + 1; j < Define.persons.size(); j++) {
						if (persons.get(i).getSalary() > persons.get(j).getSalary()) {
							Person temp = persons.get(j);
							persons.set(j, persons.get(i));
							persons.set(i, temp);
						}
					}
				}
				showListPerson(persons);
				break;
			}
			
			case 3: {
				ArrayList<Person> tempPersons = (ArrayList<Person>) Define.persons.clone();
				
				Collections.sort(tempPersons, new Comparator<Person>() {
					
					@Override
					public int compare(Person t1, Person t2) {
						
						String s1 = t1.getFullName();
						String s2 = t2.getFullName();
						return s1.compareTo(s2);
					}
				});
				showListPerson(tempPersons);
				break;
			}
			
			case 4: {
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a name: ");
				String nameSearch = sc.nextLine();
				
				ArrayList<Person> persons = new ArrayList<Person>();
				Person person;
				boolean isFound = false;
				
				for (int index = 0; index < Define.persons.size(); index++) {
					person = Define.persons.get(index);
					
					if(person.getFullName().toLowerCase().contains(nameSearch.toLowerCase())) {
						persons.add(person);
						isFound = true;
					}
				}
				
				if (isFound == false) {
					System.out.println("Cannot found!");
				} else {
					showListPerson(persons);
					persons.clear();
				}
				break;
			}
			
			case 5: {
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter year of birth: ");
				int yearOfBirth = Integer.parseInt(sc.nextLine());
				
				ArrayList<Person> persons = new ArrayList<Person>();
				Person person;
				boolean isFound = false;
				
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
						
						if (person.getType() == Define.TYPE_OF_LECTURER || person.getType() == Define.TYPE_OF_STAFF) {
							if (person.getYearOfBirth() == yearOfBirth) {
								persons.add(person);
								isFound = true;
							}
						}
					}
				
					if (isFound == false) {
						// print out "not found"
					} else {
						showListPerson(persons);
					}
			}
			
			case 6: {
				return;
			}
		}
	}

public static void menuFive() {
	while (Define.persons.isEmpty() == false) {
		Define.persons.clear();
	}
	System.out.println("Database has been wiped out");
}

public static void menuSix() {
	System.out.println("List of Empolyees & Salary \n\n");
	showListNameAndSalary(Define.persons);
}

public static void menuSeven() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter new basic salary: " + Define.newBasicSalary + "): ");
	Define.newBasicSalary = Float.parseFloat(sc.nextLine());
}

public static void menuEight() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter list of employee's id (->BlankSpace<-): ");
	String text = sc.nextLine();
	
	String indexs[] = text.split(" ");
	
	int indexTemp;
	Subject subject = new Subject();
	
	for (int index = 0; index < indexs.length; index++) {
		indexTemp = Integer.parseInt(indexs[index]);
		
		if ((indexTemp >= 0) && (indexTemp < Define.persons.size())) {
			
			if ((Define.persons.get(indexTemp).getType() == Define.TYPE_OF_LECTURER) || (Define.persons.get(indexTemp).getType() == Define.TYPE_OF_STAFF )) {
				
				subject.attach((Observer)Define.persons.get(indexTemp));
				subject.notifyChange(Define.newBasicSalary);
			} else System.out.println("Cannot edit!");
			
		} else System.out.println("Cannot found!");
	}
}

public static void menuNine() {
	System.out.println("Exit Programe");
	System.exit(0);
}

public static int selectTypeOfEmployee() {
	Scanner sc = new Scanner(System.in);
	int value;
	
	System.out.println("1. Lecturer \n" +
					   "2. Staff \n" +
					   "3. CsualWorker");
	
	value = inputSelection(1, 3);
	
	switch (value) {
		case 1: return Define.TYPE_OF_STAFF;
		
		case 2: return Define.TYPE_OF_LECTURER;
		
		default: return Define.TYPE_OF_CASUAL_WORKER;
		}
	}

public static void showListPerson(ArrayList<Person> persons) {
	System.out.format("%-4s %-20s %-8s %-8s %-4s %-6s %-6s %-6s %-6s %-6s %n", "STT", "FullName", "Birth Year", "Home Town", "Type", "C1", "C2", "C3", "C4", "C5");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-4d %-20s %-8d "
					, index
					, persons.get(index).getFullName()
					, persons.get(index).getYearOfBirth());
			
			switch (persons.get(index).getType()) {
				case Define.TYPE_OF_LECTURER: {
					System.out.format("%-8s %-4s %-6s %-6s %-6d %-6d %-6f %n",
							 ((Lecturer)persons.get(index)).getHomeTown(),
							 "GV",
							 ((Lecturer)persons.get(index)).getDepartment(),
							 ((Lecturer)persons.get(index)).getCertificate(),
							 ((Lecturer)persons.get(index)).getAllowance(),
							 ((Lecturer)persons.get(index)).getPeriodInMonth(),
							 ((Lecturer)persons.get(index)).getSalaryRatio());
					
					break;
				}
				
				case Define.TYPE_OF_STAFF: {
					System.out.format("%8s %4s %6s %6s %6d %6d %6f %n",
							 ((Staff)persons.get(index)).getHomeTown(),
							 "NV",
							 ((Staff)persons.get(index)).getDepartment(),
							 ((Staff)persons.get(index)).getPosition(),
							 ((Staff)persons.get(index)).getAllowance(),
							 ((Staff)persons.get(index)).getWorkDays(),
							 ((Staff)persons.get(index)).getSalaryRatio());
					
					break;
				}
				case Define.TYPE_OF_CASUAL_WORKER: {
					System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n",
							 "null",
							 "Casual Worker",
							 "null",
							 "null",
							 "null",
							 ((CasualWorker)persons.get(index)).getWorkdays(),
							 ((CasualWorker)persons.get(index)).getEarningPerDay());
				}
			}
		}
	
			System.out.println("\n \n \n" +
					   "C1-5 for Lecturer: Department, Qualification, Allowance, PeriodsInMonth, SalaryRatio.\n" + 
			   		   "C1-5 for Staff: Department, Position, Allowance, WorkDay, SalaryRatio.\n" +
					   "C1-5 for Casual Worker: null, null, null, WorkDay, EarningPerDay.");
}

	public static void showListNameAndSalary(ArrayList<Person> persons) {
		System.out.format("%-6s %-20s %-10s %n", "N#", "Name", "Salary");
			for (int index = 0; index < persons.size(); index++) {
				System.out.format("%-6d %-20s %-10f %n",
							 index,
							 persons.get(index).getFullName(),
							 persons.get(index).getSalary());
			}
}


	public static int inputSelection(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = min - 1;
		boolean check = false;
		
		System.out.println("Input selection (" + min + " - " + max +")");
		
		while (check == false) {
			System.out.println("Input : ");
			value = Integer.parseInt(sc.nextLine());
			
			if (value < min || value > max)
				System.out.println("Wrong input!");
			else
				check = true;
		}
		return value;
	}
}

