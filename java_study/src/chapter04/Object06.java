package chapter04;

// 클래스변수 VS 인스턴스 변수 

// 형태 
// 필드(속성, 멤버 변수) 중에 static이 붙은 것은 클래스 변수, 붙지 않은것은 인스턴스 변수 

// 선언 위치 
// >> 클래스 영역내에서 선언 

// 생성 시기 & 사용 시기 
// 1. 클래스 변수 
// >> 클래스가 메모리에 올라갈 때 
// >> 객체 생성 이전에도 사용가능 

// 2. 인스턴스 변수 
// >> 인스턴스가 생성되었을때 
// >> 객체 생성 이후에만 가능

// 호출방법 
// 클래스변수: 클래스명.변수명 
// 인스턴스변수: 객체명.변수명 

class Example {
	int instanceValue;
	static int classValue;
}

class Counter {
	// 클래스변수 
	static int count = 0;
	
	Counter() {
		count++;
	}
}


public class Object06 {
	public static void main(String[] args) {
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		Counter c4 = new Counter();
		Counter c5 = new Counter();
		
		System.out.println(c3.count); // 5
		
		new Counter();
		new Counter();
		new Counter();
		new Counter();
		new Counter();
		
		System.out.println(Counter.count); // 10
	}
}
