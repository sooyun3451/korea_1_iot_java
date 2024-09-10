package chapter10;

// java.lang 
// : 자바 프로그램의 가장 기본적인 클래스들을 포함 
// >> 별도의 import문 없이 사용 가능 

// 1. Object 클래스 
// >> 자바의 모든 클래스의 최상위 클래스, 기본적으로 생략 

class MyClass extends Object {
	// toString() 메서드 
	// : 객체의 문자열 표현을 반환 
	
	// equals() 메서드 
	// : 두 객체가 동등한지 비교 
	private int id;
	private String name;
	
	public MyClass(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MyClass" + id + name;
	}
}

// 2. Math 클래스 
// >> 수학적 연산 & 함수를 제공하는 클래스 
// >> 모든 필드와 메서드가 static! 


// 3. String 클래스 
// >> 문자열 내용 작성에 유용한 유틸리티를 담을 클래스 

public class JavaLang {
	public static void main(String[] args) {
		
		System.out.println("=== Object 클래스 ===");
		
		MyClass class1 = new MyClass(123, "홍길동");
		System.out.println(class1.toString()); // MyClass123홍길동
		
		MyClass class2 = new MyClass(456, "홍길서");
		System.out.println(class2.toString()); // MyClass456홍길서
		System.out.println(class1.equals(class2)); // false
		
		String name = "홍길동";
		String name2 = name;
		System.out.println(name.equals(name2)); // true
		System.out.println(name == name2); // true
		
		
		
		
	
		System.out.println("=== Math 클래스 ===");
		
		// Math.abs(데이터): 절대값 반환 
		double result1 = Math.abs(-3.5);
		System.out.println(result1); // 3.5
		
		// max(데이터1, 데이터2), min(a,b): 최대값, 최소값 반환 
		System.out.println(Math.max(12523423, 12493428)); // 12523423
		
		// sqrt(데이터): 제곱근 반환 
		System.out.println(Math.sqrt(4.0)); // 2.0
		
		// random(): 0.0에서 0.1 사이의 난수 생성 
		System.out.println(Math.random() * 10);
		
		// pow(a,b):거듭제곱 반환: a의 b 거듭제곱 반환 
		System.out.println(Math.pow(2, 4)); // 16
		
		
		
		
		
		System.out.println("=== String 클래스 ===");
		
		String message = "Hello, World!";
		
		// length(): 문자열 길이 반환 
		System.out.println(message.length()); // 13
		
		// equals(a, b): 두 문자열 비교 
		boolean isEqual = message.equals("Hello, World!");
		System.out.println(isEqual); // true 
		
		// substring(int 시작인덱스, int 끝인덱스): 부분 문자열 반환 
		// >> 시직번호, 끝번호 
		// >> 시작번호는 포함(이상)! 끝 번호는 미포함(미만) 
		System.out.println(message.substring(7,12)); // World
		
		// indexOf(String str): 특정 문자열의 위치를 찾음 
		int index = message.indexOf("World"); // 7
		System.out.println(index);
		
		// charAt(int index): 틀정 위치의 문자를 반환
		char ch = message.charAt(1);
		System.out.println(ch); // e
		
				
	}

}
