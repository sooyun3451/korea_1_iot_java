package chapter16;

// 내부 클래스(Inner Class)
// : 다른 클래스 내부에 선언된 클래스를 의미 

// = 장점 = 
// : 코드의 가독성 향상 - 코드의 구조 파악에 용이 
// : 클래스 간의 관계를 명확하게 함 
// - 내부 클래스는 외부 클래스의 멤버에 쉽게 접근 가능 

// = 종류 = 

// 1. 비정적 내부 클래스(가장 기본적인 클래스 형태)
// : "외부 클래스의 인스턴스"에 속함 
// >> 외부 클래스의 인스턴스 변수 및 메서드에 직접 접근 O 

// 2. 정적 내부 클래스 (static 클래스) 
// "외부 클래스의 정적 멤버", 외부 클래스의 인스턴스 변수에 접근 X 
// >> 외부 클래스의 정적 멤버에만 접근 O 
// >> new 생성자 초기화가 가능 

// 3. 메서드 내부 클래스(지역 클래스) 
// : "메서드 매에 정의된 내부 클래스", 해당 메서드 내에서만 사용 가능 
// >> 메서드의 지역 변수에만 접근 가능 
// cf) 로컬 변수가 final인 경우에만 접근 가능 

// 4. 익명(내부) 클래스 
// : 이름이 없는 내부 클래스 
// : 주로 인터페이스나 추상클래스 구현에 사용 
// >> 즉시 객체 생성 가능 
// >> 주로 클래스를 일회용으로 사용할때 이용 

// 외부 클래스 
class OuterClass {
	private String outerField = "외부 클래스의 필드";
	static String staticField = "외부 클래스 static 필드";
	
	// 비정적 내부 클래스 - 인스턴스 필드, 인스턴스(객체) 메서드처럼 사용 
	class InnerClass {
		void display() {
			System.out.println("외부 클래스 필드에 접근: " + outerField);
		}
	}
	
	// 정적 내부 클래스 (static 클래스) 
	static class StaticClass {
		void display() {
			// System.out.println("외부 클래스 필드에 접근(인스턴스): " + outerField); 
			// -Error: Cannot make a static reference to the non-static field outerField
			System.out.println("외부 클래스 필드에 접근(정적): " + staticField);
		}
	}
	
	// 메서드 내부 클래스(지역(로컬) 클래스) 
	void outerMethod() {
		final String localVar = "로컬 변수";
		
		// 메서드 내부에서만 사용 가능 
		class MethodClass {
			void display() {
				System.out.println("로컬 변수에 접근: " + localVar);
			}
		}
		
		// 로컬 클래스의 인스턴스화 
		MethodClass inner = new MethodClass();
		inner.display();
	}
}

// 추상 클래스 
// : 하나 이상의 추상 메서드를 포함 
// cf) 추상 메서드 - 구현부 {}가 없는 메서드 
abstract class AbstractClass {
	// 추상 메서드 
	abstract void display();
}

public class A_Inner01 {
	public static void main(String[] args) {
		// === 비정적 내부 클래스 ===
		// 1) 외부 클래스 인스턴스화 
		OuterClass outer1 = new OuterClass();
		
		// 2) 외부 클래스.내부 클래스 형식으로 내부 클래스를 생성 
		// 외부클래스.내부클래스타입 변수 = 외부인스턴스.new 내부클래스();
		OuterClass.InnerClass inner = outer1.new InnerClass();
		inner.display(); // 외부 클래스 필드에 접근: 외부 클래스의 필드
		
		// === 정적 내부 클래스 (static 클래스***) ===
		// 1) 외부 클래스 인스턴스화가 필요없이 클래스를 통한 내부 클래스 생성이 가능 
		// 외부클래스타입.내부클래스타입 변수 = new 외부클래스.내부클래스();
		OuterClass.StaticClass staticInner = new OuterClass.StaticClass();
		
		//  === 메서드 내부 클래스(지역 클래스) ===
		OuterClass outer2 = new OuterClass();
		outer2.outerMethod(); // 로컬 변수에 접근: 로컬 변수
		
		// === 익명 내부 클래스*** ===
		// 클래스타입 변수명 = new 클래스명() { 메서드 구현 - 추상 클래스, 인터페이스 };
		AbstractClass obj = new AbstractClass() {
			@Override
			void display() {
				System.out.println("익명 내부 클래스");
			}
		}; // 추상 클래스를 구현하는 익명 클래스 >> 재사용이 불가, 디버깅 어려움 
		
		obj.display(); // 익명 내부 클래스
	}

}
