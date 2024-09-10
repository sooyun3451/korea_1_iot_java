package chapter08;

// 다형성 
// : 많은 형태를 가질 수 있는 능력 
// >> 하나의 객체가 여러 타입의 인스턴스로 취급될 수 있는 특성 
// >> 상송 + 메서드 오버라이딩 + 클래스 타입 변환 

// instsnceof 연산 
// : 참조 변수값 instanceof 타입(클래스 명)
// >> 해당 객체가 특정 클래스의 인스턴스 인지 또는 그 클래스를 상속받은 자식 클래스의 인스턴스인지 확인


// vehicle 운송수단, 탈것 
class Vehicle {
	void display() {
		System.out.println("운송수단 입니다.");
	}
}

class Bus extends Vehicle {
	@Override
	void display() {
		System.out.println("버스를 타고 갑니다.");
	}
}

class Subway extends Vehicle {
	@Override
	void display() {
		System.out.println("지하철을 타고 갑니다.");
	}
}

public class B_Polymorphism {
	public static void main(String[] args) {
		// 다형성 적용 
		// : 부모클래스 타입의 참조 변수로 자식 클래스 객체를 참조 
		Vehicle myVehicle = new Vehicle(); // Vehicle 객체 
		
		Vehicle myBus = new Bus(); // Bus 객체 (자동 타입 변환)
		
		Vehicle mySubway = new Subway(); // Subway 객체(자동 타입 변환)
		
		if(myBus instanceof Vehicle) {
			// myBus 객체가 Vehicle의 인스턴스 이거나 해당 클래스를 상속받은 클래스의 인스턴스인 경우 
			myBus.display(); // 버스를 타고 갑니다.
		}
		
		if(myVehicle instanceof Bus) {
			System.out.println("운송수단은 버스입니다.");
		}else {
			System.out.println("운송수단은 버스가 아닙니다.");
			// 운송수단은 버스가 아닙니다.
		}
		
		// cf) instanceof 연산자 계산식에서 true의 결과값이 출력되면 
		// >> 해당 클래스 타입으로 형 변환이 가능 
		// >> 형 변환 이전에는 instanceof 연산자를 통해 오류 방지 
	}

}
