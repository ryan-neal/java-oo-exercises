package pset9;

import blogz.User;

public class Student {
	private String firstName;
	private String lastName;
	private double GPA;
	private int ID;
	private int credits;
	
	public Student(String fName, String Name, int ID) {
		this.firstName = fName;
		this.lastName = Name;
		this.GPA = 0.0;
		this.ID = ID;
		this.credits = 0;
	}
	
	public String getName(){
		return this.firstName + " " + this.lastName;
	}
	
	public int getStudentID(){
		return this.ID;
	}
	
	public double getGPA(){
		return this.GPA;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public void setGPA(double GPA){
		this.GPA = GPA;
	}
	
	public void setCredits(int credits){
		this.credits = credits;
	}
	
	public String getClassStanding(){
		if (this.credits >= 90) {
			return "Senior";
		}
		else if (this.credits >= 60) {
			return "Junior";
		}
		else if (this.credits >= 30) {
			return "Sophomore";
		}
		else {
			return "Freshman";
		}
	}
	
	public void submitGrade(double grade, int credits){
		double current_gpa = this.credits * this.GPA;
		double to_add = grade * credits;
		this.credits += credits;
		double qs = current_gpa + to_add;
		this.GPA = Math.round(qs/ this.credits* 1000.0)/1000.0;
	}
	
	public double computeTuition() {
		double x = this.credits/15;
		double y = this.credits % 15.0;
		double answer = (x * 20000) + (y * (1333.33));
		return answer;
	}
	
	public Student createLegacy(Student student){
		String firstName = this.getName();
		String lastName = student.getName();
		int new_id = this.ID + student.ID;
		double baby_gpa = (this.GPA + student.GPA) / 2;
		int baby_credits = Math.max(this.credits, student.credits);
		Student baby = new Student(firstName, lastName, new_id);
		baby.setGPA(baby_gpa);
		baby.setCredits(baby_credits);
		return baby;
	}
	
	public String toString(){
		return this.getName() + " " + this.ID;
	}
	
//	public boolean equals(Object o){
//		if (this == o){
//			return true;
//		}
//		if (o == null){
//			return false;
//		}
//		
//		if (getClass() != o.getClass()){
//			return false;
//		
//		}
//
//		Student stud = (Student) o;
//		
//		return s

}
