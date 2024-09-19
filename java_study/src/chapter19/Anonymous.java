package chapter19;

// === 익명 클래스 정의 === 
// : 클래스를 정의하면서 동시에 객체를 생성하는 방법 
// >> 이름이 없기 때문에 재사용 X, 일회성 사용 객체 정의에 유용 

// === 익명 클래스의 특징 ===
// 1. 힌 번만 사용하는 인터페이스, 추상 클래스 구현 
// 2. 특정 로직을 캡슐화 - 내부 클래스의 일종 
// 3. 명시적인 생성자를 가질 수 X 

// === 익명 클래스의 기본 형태 ===
// : 인터페이스 또는 추상 클래스를 구현 
// new 인터페이스_또는_추상클래스() {
// 메서드 오버라이딩 및 클래스 구현 
// }

// === 익명 클래스의 장단점 ===
// 1. 장점 
// - 간결함: 클래스 선언과 인스턴스 생성이 동시적으로 처리 
// - 캡슐화: 일회성 로직 사용으로 특정 위치에서만 사용되고 외부에 노출 X 

// 2. 단점 
// - 여러개의 익명 클래스 사용 시 코드의 가독성 저하 
// - 이름이 없기 때문에 디버깅에 어려움 
// - 재사용의 불가능 

// 1. 인터페이스 구현 예시 
interface Animal {
	void sound(); // 추상 메서드 - 구현 {}이 없는 메서드
	// +) 람다형식으로 변환 가능한 인터페이스는 함수형 인터페이스로 단 하나의 추상 메서드만을 가지는 구조
}

// 2. 추상 클래스 구현 예시 
abstract class Vehicle {
	abstract void run(); // 추상 메서드
}

// == 추상 클래스 Person 정의 ==
abstract class Person {
	abstract String getName();
}

public class Anonymous {
	public static void main(String[] args) {
		Animal dog = new Animal() {

			@Override
			public void sound() {
				System.out.println("멍멍");
			}
		};
		dog.sound(); // 멍멍

		
		Vehicle car = new Vehicle() {

			@Override
			void run() {
				System.out.println("자동차가 달립니다.");
			}
		};
		car.run(); // 자동차가 달립니다.
		
		
		Person person = new Person() {
			
			@Override
			public String getName() {
				return "홍길동";
			}
		};
		System.out.println(person.getName()); // 홍길동

	}

}
