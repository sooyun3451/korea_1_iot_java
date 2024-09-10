package chapter12.model;

public class Student {
	private int studentCode;
	private String studentName;
	
	public Student(int studentCode, String studentName) {
		this.studentCode = studentCode;
		this.studentName = studentName;
	}
	
	public int getStudentCode() {
		return studentCode;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	@Override
	public String toString() {
		return "StudentCode: " + studentCode + "StudentName" + studentName;
	}

}
