package chapter16;

// 람다표현식
// : 익명 함수를 간결하게 표현, 한 번만 사용되는 함수를 정의 
// >> 코드 양을 줄이고 가독성을 향상 

// === 기본 구조 ===
// (매개변수목록) -> { 함수 본문 }
// (int x, int y) -> { return x + y; }

// === 람다표현식의 축약 ===
// 1. 중괄호 생략 가능: 본문이 단일 명령문인 경우 
// 2. return 생략 가능: 본문이 단일 명령문인 경우 
// 3. 매개변수 타입 생략 가능: 컴파일러가 타입을 추론할 수 있는 경우 
// >> 자바 프로그램 내의 타입인 경우 (기본, 참조 자료형) 

// === 람다표현식의 활용 === 
// : 함수형 인터페이스에서 주로 사용 
// >> 오직 하나의 추상 메서드를 가지는 인터페이스 

interface IExample {
	String message(String msg); // 추상 메서드 
}

public class C_Lambda02 {
	public static void main(String[] args) {
		IExample hello = (a) -> {
			return a;
		};
		
		hello.message("안녕하세요");
		System.out.println(hello.message("hello")); // hello
	}

}
