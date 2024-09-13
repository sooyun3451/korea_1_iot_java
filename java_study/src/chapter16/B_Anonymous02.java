package chapter16;

// 학생 클래스 - 기본 클래스 
class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
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

// 인터페이스 정의 - 성적 계산
interface Grading {
	String calculateGrade(Student student); // 추상 메서드
}

public class B_Anonymous02 {
	public static void main(String[] args) {

		Student student1 = new Student("홍길동", 85);
		Student student2 = new Student("홍길서", 72);
		Student student3 = new Student("홍길남", 90);
		Student student4 = new Student("홍길북", 65);
		Student student5 = new Student("최소윤", 81);

		Grading grading = new Grading() {

			@Override
			public String calculateGrade(Student student) {
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
			}
		};
		
		System.out.println(student1.getName() + "의 성적" + grading.calculateGrade(student1)); // 홍길동의 성적B
		System.out.println(student2.getName() + "의 성적" + grading.calculateGrade(student2)); // 홍길서의 성적C
		System.out.println(student3.getName() + "의 성적" + grading.calculateGrade(student3)); // 홍길남의 성적A
		System.out.println(student4.getName() + "의 성적" + grading.calculateGrade(student4)); // 홍길북의 성적D
		System.out.println(student5.getName() + "의 성적" + grading.calculateGrade(student5)); // 최소윤의 성적B

	}

}
