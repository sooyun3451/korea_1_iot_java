package chapter12.view;

import java.util.List;
import java.util.Scanner;

import chapter12.controller.StudentController;
import chapter12.model.Student;

public class StudentView {
	private Scanner scanner;
	
	private StudentController studentController;
	
	public StudentView() {
		this.scanner = new Scanner(System.in);
		studentController = new StudentController();
	}
	
	public void showMene() {
		int choice = 0;
		while(choice != 4) {
			System.out.println("1. Add a Student");
			System.out.println("2. Show all Students");
			System.out.println("3. Search for a student");
			System.out.println("4. Quit");
			System.out.print("메뉴를 선택해주세요: ");
			
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1: 
				addStudentView();
			case 2:
				showAllView();
				break;
			case 3:
				searchStudentView();
				break;
			default:
				System.out.println("종료하겠습니다.");
				break;
			}
		}
	}
	
	private void addStudentView() {
		System.out.println("학생코드를 입력해주세요.");
		int studentCode = scanner.nextInt();
		
		System.out.println("학생이름을 입력해주세요.");
		String studentName = scanner.nextLine();
		
		studentController.addStudent(studentCode, studentName);
	}
	
	private void showAllView() {
		List<Student> students = studentController.getAllStudent();
		
		for(Student student: students) {
			System.out.println(student.toString());
		}
		
	}
	
	private void searchStudentView() {
		System.out.println("학생을 검색해주세요.");
		String name = scanner.nextLine();
		List<Student> students = studentController.searchStudent(name);
		
		for(Student student: students) {
			System.out.println(student.toString());
		}
	}
	

}
