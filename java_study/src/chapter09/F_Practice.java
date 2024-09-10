package chapter09;

// 인터페이스 
// Fruit 인터페이스 정의 
// - color라는 추상 메서드 
// - describe라는 디폴트 메서드 
// - printType 라는 정적 메서드 

interface Fruit {
	String color(); // 추상메서드 - public, abstract생략

	// 디폴트 메서드
	// >> 재정의 가능
	default void describe() {
		System.out.println("과일의 색상" + color() + "입니다");
	}

	// 정적 메서드
	// >> 재정의 불가"
	static void printType() {
		System.out.println("과일(Fruit)의 타입입니다.");
	}
}

// === 인터페이스 구현 === 
class Apple implements Fruit {
	@Override
	public String color() {
		return "red";
	}
	// 디폴트 메서드 재정의 X
	// >> Fruit에 있는 디폴트 메서드가 생략된 형태
}

class Orange implements Fruit {
	@Override
	public String color() {
		return "orange";
	}
}

public class F_Practice {
	public static void main(String[] args) {
		Fruit apple = new Apple();
		apple.describe(); // 과일의 색상red입니다
		
		Fruit orange = new Orange();
		orange.describe(); // 과일의 색상orange입니다
		
		
		// 정적 메서드 활용 - 인터페이스 자체로 호출 
		Fruit.printType(); // 과일(Fruit)의 타입입니다.
	}

}
