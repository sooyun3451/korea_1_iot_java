package chapter05;

// 정적 메서드 
// : 메서드 앞에 static 키워드를 붙여 클래스(정적)메서드 생성 
// >> 인스턴스 생성 없이도 호출 가능한 메서드 
// 	  클래스명.메서드명(매개변수 ... )

// === 사용 권장 사항 ===
// 1. 클래스 설계 시, 변수(속성) 중 모든 인스턴스가 공통적으로 사용하는 값
// 2. 인스턴스 변수를 사용하지 않는 경우에 static 사용 

class Operator {
	// 인스턴스 변수 
	int a, b;
	
	// 인스턴스 메서드: 인스턴스 변수 a, b가 필요한 작업 
	// >> 매개변수가 필요하지 않는 경우가 있음 
	int add() { return a + b; }
	int subtract() { return a - b; }
	
	// 정적 메서드: 인스턴스 변수와 관계없이 매개변수 만으로 작업 
	static int multiply(int a, int b) { return a * b; }
	static int divide(int a, int b) { return a / b; }

public class Method04 {
	public static void main(String[] args) {
		System.out.println("=== 인스턴스 메서드 ===");
		// 인스턴스 생성 
		Operator op = new Operator();
		
		op.a = 10;
		op.b = 20;
		
		System.out.println(op.add()); // 30
		System.out.println(op.subtract()); // -10
		
		System.out.println("=== 정적 메서드 ===");
		// 정적(클래스) 메서드 호출
		// : 클래스명.메서드명(매개변수 .. )
		int result1 = Operator.multiply(10, 20);
		int result2 = Operator.divide(10, 20);
		
		System.out.println(result1); // 200 
		System.out.println(result2); // 0
		
	}
		
	}
}
