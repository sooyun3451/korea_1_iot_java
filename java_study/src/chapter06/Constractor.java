package chapter06;

// 클래스 구조 
// : 변수, 메서드, 생성자 

// === 생성자 ===
// : 인스턴스(객체)가 생성될 때 호출되는 '인스턴스 초기화 메서드'

// 생성자 조건
// : 생성자 이름은 클래스 이름과 동일 
// : 리턴값이 없는 메서드 형식 (void 생략 가능)

// - 생성자가 인스턴스 생성 X (생성자 - 만들고)
// - new 키워드가 인스턴스를 생성 (new - 메모리에 올리는 일을 한다 생각)

// 컴파일러가 제공하는 기본 생성자(매개변수 X, 아무런 구현 X)가 생략 
class Data1 {
	int value;
}

// 사용자 정의 생성자를 만드는 경우 컴파일러가 자동으로 기본 생성자를 제거 
class Data2 {
	int value;

	Data2(int x) {
		value = x;
	}
}

class Car {
	String color;
	String gearType; // 자동(auto) 수동(manual)  
	int door;
	
	Car() {} // 기본 생성자 - 차를 생성 후 작업 
	
	// 사용자 정의 생성자 
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	Car(String color) {
		// +) 정의 생성자에서 다른 생성자 호출 - this 
		// : 생성자 이름으로 클래스 이름 대신 this를 사용 
		// : 정의 생성자에서 다른 생성자 호출 시 반드시!!! 첫 줄에서만 호출 가능 
		// >> 호출된 생성자가 변수값 초기화를 하는 경우 해당 생성자가 수행하는 작업을 유지하기 위함(무의미함 방지!)
		
		this(color, "auto", 4); // 생성자 메서드를 가리킴 
		door = 5;
		// >> 객체 생성 시 색상만 작성하는 경우 
		// 색상 + auto + 문의 개수 5개 
	
		// this(color, "auto", 4); -Error: Constructor call must be the first statement in a constructor
	}
	
	void displayInfo() {
		System.out.println(color + gearType + door);
	}
}

public class Constractor {
	public static void main(String[] args) {
		Data1 data1 = new Data1();
		data1.value = 10;

		Data2 data2 = new Data2(10);

		System.out.println(data1.value);
		System.out.println(data2.value);
		
		System.out.println("Car 클래스 사용");
		Car c1 = new Car(); // 기본 생성자 
		c1.color = "red";
		c1.door = 2;
		c1.gearType = "수동";
		c1.displayInfo(); // red수동2
		
		Car c2 = new Car("white", "manual", 4); // 사용자 정의 생성자 
		c2.displayInfo(); // whitemanual4
		
		Car c3 = new Car("blue");
		c3.displayInfo(); // blueauto5
		
		// === 객체 지향 프로그래밍의 this ===
		// 1. this
		// >> 인스턴스 자신을 가리키는 참조 변수
		// >> 인스턴스의 주소값을 저장
		// : 모든 인스턴스 메서드에서 지역변수로 생략되어 존재
		
		// 2. this();
		// >> 생성자, 같은 클래스의 다른 생성자를 호출 할 때 사용
	}

}
