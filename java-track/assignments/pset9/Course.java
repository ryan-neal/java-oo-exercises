package pset9;

import java.util.ArrayList;

public class Course {
	private String name;
	private int credits;
	private int seatsRemaining;
	private ArrayList<Student> students;
	
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.seatsRemaining = seats;
		this.students = new ArrayList<Student>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getRemainingSeats(){
		return this.seatsRemaining;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public boolean addStudent(Student student) {
		if (students.contains(student)){
			return false;
		}
		
		if (this.seatsRemaining > 0) {
			students.add(student);
			this.seatsRemaining --;
			return true;
		}
		else{
			return false;
		}
	}
	
	public double averageGPA(){
		double gpa_sum = 0;
		for (Student student: students) {
			gpa_sum += student.getGPA();
		}
		gpa_sum = (gpa_sum/students.size());
		return gpa_sum;
	}
	
	public String toString(){
		return this.getName() + " " + this.getCredits();
	}
}
