package vn.edu.vnuk.model;

public abstract class Person {
	protected String fullName;
	protected int yearOfBirth;
	protected int id;
	protected int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Person( ) {}
	
	public Person ( String fullName, int yearOfBirth, int id) {
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract String toString();
	public abstract void input();
	public abstract float getSalary();
}

