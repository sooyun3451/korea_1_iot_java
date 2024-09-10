package chapter04;

// 객체 지향 프로그래밍 - 클래스와 객체 

// 1. 클래스(Class) 정의 
// - 객체를 만들기 위한 템플릿
// - 객체의 상태(속성)과 행동(메서드)을 정의 
// >> 실제 데이터나 코드 X, 데이터와 기능의 구조를 정의하는 하나의 개념적인 틀 
// : Class 키워드를 사용하여 정의 

// 2. 객체(Object) 정의 
// - 클래스에 정의된 속성과 메서드를 가지고 있는 '실체' 
// - 클래스를 기반으로 생성, 클래스의 인스턴스라고 불람 
// >> 각 객체는 독립적인 상태와 행동을 가짐 
// >> 다른 객체와 상호작용 가능 

public class Object02 {
	public static void main(String[] args) {
		// 클래스 선언 방법 
		// [접근제한자]class Class Name {
			// 속성(변수) & 메서드(함수) 
		//}
		
		// : 접근 제한자(제어자)는 생략 가능 
		// >> 클래스의 가시성을 정의 (접근에 대한 권한을 부여)
		// >> public, private, protected, default 
		
		// public: 모든 클래스에서 접근 가능 
		// private: 해당 클래스 내부에서만 접근 가능 
		// protected: 같은 패키지 내부 또는 상속 관계에 있는 클래스에서만 접근 가능 
		// default: 같은 패키지 내에서만 접근 가능 
		
		class Car {
			// 속성(필드)
			int maxSpeed;
			double weight;
			boolean isElectic;
		}
		
		
		class Book {
			String title;
			String author;
			int[] pageNumber;
		}
		
		
		class Person {
			String name;
			int age;
			double height;
			boolean isEmployed;
		}
	}

}
