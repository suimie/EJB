package test;

public class Student {
	private String name;
	private int studentID;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studentID=" + studentID + ", getName()=" + getName() + ", getStudentID()="
				+ getStudentID() + "]";
	}	
}
