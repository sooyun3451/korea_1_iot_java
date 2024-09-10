package chapter09;

interface Flyable {
	// 상수 final 생략 (public static final)
	// >> UPPER_SNAKE_CASE 사용 권장 
	// >> 선언과 동시에 초기화 
	int MAX_SPEED = 100;
	
	void fly(); // (public abstract 생략)
	
	// 디폴트 메서드 >> 재정의 가능 
	default void land() {
		System.out.println("Landing");
	}
	
	// 정적 메서드 >> 재정의 불가능 
	static int getWingCount() {
		return 2;
	}
}

class Bird implements Flyable {
	// 인터페이스를 구현하는 클래스에서 인터페이스에 정의된 상수 사용가능 
	@Override
	public void fly() {
		System.out.println("새는 최대속력이" + MAX_SPEED + "입니다.");
	}
	
	@Override
	public void land() {
		System.out.println("...Landing...");
	}
}

public class C_Interface {
	public static void main(String[] args) {
		Bird bird = new Bird();
		
		bird.fly(); // Bird 구현 메서드 (새는 최대속력이100입니다.)
		bird.land(); // 디폴트 메서드 - 재정의 동작 (...Landing...)
		System.out.println(Flyable.getWingCount()); // 정적 메서드 - 인터페이스 호출 (2)
		
	}

}
