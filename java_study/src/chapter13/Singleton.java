package chapter13;

// singleton 패턴 
// : 소프트웨어 설계 패턴 중 하나 
// >> 클래스의 인스턴스가 하나만 생성되도록 보장 
// >> 해당 클래스의 인스턴스에 전역적인 접근을 제공하지만 일관된 상태를 유지 
public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}; // 생성자를 private으로 선언 - 외부에서 적접 인스턴스 생성 X

	// 전역 접근성을 제공하는 메서드를 제공
	public static Singleton getInstance() {
		if (instance == null) { // 정적 변수에 아무런 값이 없다면(한번도 인스턴스화 X)
			instance = new Singleton();
		}
		return instance;
	}
	
	// cf) 싱글턴 패턴의 장단점 
	// 장점: 자원의 중복 생성을 방지, 메모리 사용 최적화, 전역 상태를 공유 + 통제된 접근 
	// 단점: 전역 상태를 관리 + 다른 클래스에 영향(결함의 가능성), 테스트가 어려움 
}
