package chapter16;

import java.util.ArrayList;
import java.util.Comparator; // 두 객체를 비교하는데 사용되는 함수형 인터페이스 
import java.util.List;

// 람다 표현식(Lambda Expression)
// : 함수형 인터페이스 구현에 사용, 자바 8에서 도입된 기능 
// >> 간결성, 함수형 프로그래밍 지원 등의 특징 
// >> 익명 클래스를 대체하여 코드의 가독성 향상에 기여 

// === 기본형태 ===
// (매개변수1, 매개변수2, ... ) -> { 실행할 코드 }

// 매개변수: 함수형 인터페이스에서 메서드와 동일한 매개변수를 사용 
// 화살표: 매개변수와 실행할 코드의 구문 
// 코드 블록: 중괄호 영역
// cf) 단일 표현식인 경우 중괄호 생략 가능 

//학생 클래스 - 기본 클래스 
class Student2 {
	private String name;
	private int score;

	public Student2(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}

//인터페이스 정의 - 성적 계산
interface Grading2 {
	String calculateGrade(Student2 student); // 추상 메서드
}

public class C_Lambda01 {
	public static void main(String[] args) {
		List<Student2> students = new ArrayList<Student2>();
		
		students.add(new Student2("홍길동", 85));
		students.add(new Student2("홍길서", 75));
		students.add(new Student2("홍길남", 68));
		students.add(new Student2("홍길북", 90));
		students.add(new Student2("최소윤", 97));
		
		// 람다 표현식을 사용한 성적 계산 
		Grading2 grading = (Student2 student) -> {
			int score = student.getScore();
			if (score > 100 || score < 0) {
				System.out.println("잘못된 점수입니다.");
				return null;
			} else if (score >= 90) {
				return "A";
			} else if (score >= 80) {
				return "B";
			} else if (score >= 70) {
				return "C";
			} else if (score >= 60) {
				return "D";
			} else {
				return "F";
			}
		};
		
		// 성적 출력 
		for(Student2 student: students) {
			System.out.println(student.getName() + "의 성적" + grading.calculateGrade(student));
		}
		
		// 학생 성적에 따라 정렬 
		students.sort(Comparator.comparingInt(Student2::getScore)); // 오름차순 
		students.sort(Comparator.comparingInt(Student2::getScore).reversed()); // 내림차순 
		for(Student2 student: students) {
			System.out.println(student.getName() + "의 성적" + student.getScore());
		}
		
		
		// cf) 메서드 참조 
		// (Student2 st) -> getScore(st);
		// Student2::getScore
		
		// (x) -> 인스턴스.메서드명(x);
		// 인스턴스::메서드명 
		
		// (x) -> 클래스명.메서드명(x);
		// 클래스::메서드명 
	}

}
