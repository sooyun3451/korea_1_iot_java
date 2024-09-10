package chapter13;

import lombok.Data;

// 자바 제네릭
// : 클래스나 메서드를 정의할때 사용할 데이터 타입을 미리 지정하는 대신 
// >> 구체적인 사용 시 타입으로 대체 
// >> 특정 타입에 의존하지 않고 다양한 타입을 지원하는 클래스 또는 메서드 설계 

// class 클래스명<제네릭 타입>
class Pair<K, V> {
	// (접근제어자) 반환타입 필드명;
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getvalue() {
		return value;
	}

	// 제네릭 메서드
	// (접근제한자 static) <제네릭 타입>반환타입 메서드명() {}
	static <T> void print(T value) {
		System.out.println(value);
	}
}

// === 제네릭 와일드 카드 ===
// : ? 기호를 사용
// >> 제네릭 타입을 불특정하게 사용하도록 지정 
// >> 주로 클래스 간에 상속 관계인 경우 사용 
class Message<T> {
	private T message;

	public T getMessage() {
		return message;
	}
}


public class Generic {
	public static void main(String[] args) {
		// [ Wrapper 자료형 ]
		// Integer >> int
		// Boolean >> boolean
		// Character >> char
		Pair<String, Integer> pair = new Pair<>("안녕하세요.", 123);

		System.out.println(pair.getKey()); // 안녕하세요.
		System.out.println(pair.getvalue()); // 123

		Pair.print("반갑습니다."); // 반갑습니다.
		Pair.print(123); // 123

		// === 와일드 카드의 경우 타입에 대한 유연성을 제공 ===
		Message<?> m1;
		Message<String> m2 = null;

		m1 = new Message<>();
		String s = (String) m1.getMessage();
		Boolean b = (Boolean) m1.getMessage();
		// cf) 제네릭의 한계 
		// : 기본 타입과 함께 사용할 수 X 
		// >> 반드시 참조타입으로 사용 
	}

}
