package chapter07;

// === 자바 패키지 또는 클래스 파일 간의 코드 연결 ===
// : import문을 사용

// 같은패키지 내: import 클래스파일명;
// 다른패키지: import 패키지명.클래스파일명;
import otherPackage.ParentClass;

// 접근 제어자(Modifier)
// : 클래스, 메서드, 변수의 접근 범위를 제어 

// 1. 접근 제어자의 종류 
// : private, default, protected, public 
// >> 접근지정자가 지정되지 않은 경우 default(기본값)으로 지정 

// +) 클래스 자체에 접근 제한자 사용 X 
// >> 중첩 클래스의 경우 사용 가능 

// 2. 접근 제어자의 범위 
// public > protected > (default) > private 

// 1) private 
// : 같은 클래스 내에서만접근 가능 
class PrivateClass {
	private int myField;
	private void myMethod() {}
}

// 2) default 
// : 같은 패키지 내라면 중복 X
// : 패키지 외부에서는 접근 X
// >> 패키지 내부에서는 중복 X, 접근 O 
class DefaultClass {
	// 같은 패키지 내의 다른 클래스 들에 접근 가능 
	int myField;
	void myMethod() {}
}

// 3) protected 
// : 동일한 패키지 내의 모든 클래스와 다른 패키지의 하위 클래스에서 접근 가능 
class ProtectedClass extends ParentClass {
	protected int myField;
	
	public ProtectedClass() {
		// protected 속성과 메서드일 경우 >> 상속받은 클래스에서 다른 패키지더라도 접근 가능 
		System.out.println(protectedField); // 안녕하세요
		exampleMethod(); // 상속받은 클래스에서 호출 가능
	}
}


// 어떤 클래스든 어떤 패키지 내에 있든 접근 가능 
public class A_Modifier {
	static String name = "홍길동";
	
	public static void main(String[] args) {
		PrivateClass privateClass = new PrivateClass();
    	// privateClass.myField; -Error: The field PrivateClass.myField is not visible
		// >> private 설정 된 속성과 메서드는 해당 클래스 내부에서만 읽을 수 있음 
		
		DefaultClass defaultClass = new DefaultClass();
		defaultClass.myField = 10;
		defaultClass.myMethod();
		
		ProtectedClass protectedClass = new ProtectedClass();
		// protectedClass.exampleMethod(); -Error: ParentClass 에서 default
	}

}
