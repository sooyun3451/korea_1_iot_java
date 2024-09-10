package chapter12.controller;

import java.util.ArrayList;
import java.util.List;

import chapter12.model.Student;

public class StudentController {

	private List<Student> students;
	
	public StudentController() {
		this.students = new ArrayList<Student>();
	}
	
	public void addStudent(int studentCode, String studentName) {
		Student student = new Student(studentCode, studentName);
		students.add(student);
	}
	
	public List<Student> getAllStudent() {
		return students;
	}
	
	public List<Student> searchStudent(String studentName) {
		List<Student> students = new ArrayList<Student>();
		
		for(Student student: students) {
			if(student.getStudentName().contains(studentName)) {
				students.add(student);
			}
		}
		
		return students;
	}
}
