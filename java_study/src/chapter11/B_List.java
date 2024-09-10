package chapter11;

import java.util.ArrayList;
import java.util.LinkedList;

//! List 인터페이스
//: 데이터를 "순차적"으로 저장하고 접근하는데 사용하는 메서드를 정의
//: 데이터의 "중복 저장"을 허용, 저장된 순서에 따라 데이터를 관리

//! List 특징
//- 요소의 인덱스를 통한 정확한 위치 지정
//- 요소의 중복 허용
//- 다양한 구현체를 통해 사용 가능

//=== List 인터페이스 구현 클래스 ===

//== ArrayList: 내부적으로 배열을 사용하여 데이터를 관리 ==

//1. 동적 크기를 조절
//- 요소가 추가되거나 제거될 때 자동으로 크기를 조절
//2. 인덱스 기반 접근
//- 특정 위치의 데이터를 빠르게 읽거나 수정 가능
//- 중간에 데이터를 삽입하거나 삭제하는 작업은 비교적 느림
//3. 순차적인 데이터 저장, 중복 데이터 허용
//4. 널(Null) 값을 허용

//>> 데이터를 빠르게 조회할 때 사용 (데이터의 삽입, 삭제 X)
//>> null 값을 허용, null값이 허용될 수 있는 상황에서는 null 체크를 항상 동반
		
//== LinkedList: 내부적으로 이중 연결된 리스트를 사용하여 데이터를 관리 ==
//: 내부적으로 이중 연결 리스트를 사용

//1. 동적 크기 조절: 자동으로 크기 조절
//2. 데이터 삽입 / 삭제 효율
//- 특정 위치에서의 요소 추가/삭제가 빠름
//- 특정 위치의 요소에 접근하는 것은 리스트를 순회해야 하기 때문에 속도가 비교적 느림
//3. 널(Null)값을 허용

//>> 데이터의 연결성을 사용한 순차적인 접근에 적합
//>> null 값을 허용, null값이 허용될 수 있는 상황에서는 null 체크를 항상 동반

public class B_List {
	public static void main(String[] args) {
		// === List 인터페이스의 주요 메서드 === 
		// - add(E e): 리스트의 끝에 요소를 추가
		// - add(int index, E e): 지정된 위치에 요소를 추가
		// - get(int index): 저장된 위치의 요소를 반환
		// - remove(int index): 지정된 위치의 요소를 제거하고, 그 요소를 반환
		// - size(): 리스트의 크기(요소의 수)를 반환
		// - clear(): 리스트의 모든 요소를 제거
		// - indexOf(Object o): 지정된 요소가 처음으로 나타나는 위치의 인덱스를 반환
		// - contains(Object o): 리스트가 특정 요소를 포함하는지 여부를 반환
		// - set(int index, E e): 지정된 위치에 주어진 요소를 저장 이전에 있던 요소를 반환
		
		// 1. ArrayList 사용 예시 
		System.out.println("=== ArrayList ===");
		
		// - new 생성자를 사용하여 ArrayList 객체를 생성 
		// >> 일반 데이터 타입X, "클래스 객체 데이터" 타입 
		// EX) String, Number, Boolean 등 
		
		// 컬렉션명<객체데이터> 변수명 = new 켤렉션명<객체데이터>();
		ArrayList<String> strArray = new ArrayList<String>(); 
		
		System.out.println(strArray.size()); // 0
		
		strArray.add("JAVA");
		strArray.add("PYTHON");
		strArray.add("JS");
		strArray.add("TS");
		
		System.out.println(strArray.size()); // 4
		System.out.println(strArray); // [JAVA, PYTHON, JS, TS]
		
		strArray.add(1, "REACT");
		System.out.println(strArray); // [JAVA, REACT, PYTHON, JS, TS]
		
		String element = strArray.get(1);
		System.out.println(element); // REACT
		
		System.out.println(strArray.remove(1));
		System.out.println(strArray); // [JAVA, PYTHON, JS, TS]
		
		System.out.println(strArray.set(1, "C++")); // PYTHON(밀려난 요소 반환)
		System.out.println(strArray); // [JAVA, C++, JS, TS]
		
		
		// === 2.LinkedList 사용 예시 ===
		System.out.println("=== LinkedList ===");
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("Apple");
		linkedList.add("Banana");
		linkedList.add("Orange");
		
		System.out.println(linkedList); // [Apple, Banana, Orange]
		
		linkedList.add(1, "Mange");
		System.out.println(linkedList); // [Apple, Mange, Banana, Orange]
		
		String fruitElement = linkedList.get(2);
		System.out.println(fruitElement); // Banana
		
		String isFruit1 = "Orange";
		String isFruit2 = "Strawberry";
		
		System.out.println(linkedList.contains(isFruit1)); // true
		System.out.println(linkedList.contains(isFruit2)); // false
		
		linkedList.clear();
		System.out.println(linkedList); // []
		
		// cf) List 컬렉션 프레임워크 사용 시 유의사항 
		
		
		// get, remove, set 메서드 사용 시 
		// : 인덱스 번호를 사용하는 메서드
		// >> 인덱스 번호가 유효한지 검사(유효하지 않은 경우 IndexOutOfBounds 예외)
	}

}
