package chapter05;


// === 용어 정리 ===
// 클래스, 객체, 인스턴스 
// 변수: 속성(필드 - 인스턴스 변수, 정적(클래스) 변수) / 지역 변수 
// 메서드: 인스턴스 메서드, 정적(클래스) 메서트 
// 생성자 

// === (메서드) 오버로딩 ===
// : overloading
// : 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것 

// 1. 오버로딩의 성립 조건 
// - 메서드 이름이 같아야함 
// - 매개변수의 개수 또는 타입이 달라야 함 
// - 반환타입은 관계 없음 

// 2. 오버로딩의 장점 
// - 사용자가 매개변수의 순서를 외우지 않아도 사용 가능 (편의성)

// 3. 오버로딩의 단점 
// - 중복적으로 의미 없이 생성하는 경우, 실질적으로 필요한 구현 메서드 찾기에 어려움 (복잡성) 

class Calc {
	int a, b;
	int c, d;
	double x, y;
	
	// 두 정수를 더하는 메서드 
	int add(int a, int b) { return a + b; }
	
	// 실제 값 차이 여부와 반환타입의 차이 여부는 오버로딩과 관련 X
	// >> 반드시!! 매개변수의 개수 또는 타입이 달라야 함!
	// long add(int c, int d) { return c + d; } -Error
	
	// === 매개변수의 타입 차이 ===
	double add(double x, double y) { return x + y; }
	double add(int a, double y) { return a + y; }
	double add(double x, int b) { return x + b; }
	
	// === 매개변수의 개수 차이 === 
	int add(int a, int b, int c) {return a + b + c; }
	
	
	// cf) 오버 로딩 사용 이유
	// 1. 메서드가 수행하는 기본적인 작업이 동일할 때, 같은 이름 사용 가능
	// : - 코드를 더 명확하고 가독성 있게 작성 가능
	// 2. 코드의 재사용성이 높아짐
	// 3. 컴파일 시 타입 체크를 강화 - 올바른 매개변수 타입을 가진 메서드를 선택
}


public class Overloading01 {
	public static void main(String[] args) {
		Calc calculator = new Calc();
		System.out.println(calculator.add(10, 20)); // 30
		System.out.println(calculator.add(10.3, 20)); // 30.3
		System.out.println(calculator.add(10, 20.3)); // 30.3 
		System.out.println(calculator.add(10, 20, 30)); // 60 

	}

}
