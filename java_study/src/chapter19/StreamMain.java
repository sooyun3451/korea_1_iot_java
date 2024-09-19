package chapter19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// === 스트림 API ===
// : 자바 8에서 처음 도입 
// >> 컬렉션 데이터를 처리하는 도구 

// +) 스트림의 특징 
// - 일회성: 한번 소비되면 다시 사용 X, 새로운 스트림을 생성하여 사용해야 함.
// - 연산의 분류: 스트림 연산은 중간, 최종연산으로 나뉨 
// 	>> 중간 연산: map, filter, sorted 
//				  데이터를 가공하지만 실제로 연산은 최종 연산의 호출 시 수행 
//	>> 최종 연산: collect, forEach, reduce 등 
//                스트림의 결과를 반환하고 스트림을 종료 

/*
 	=== 스트림 생성(사용) 절차 ===
 	1. 배열 생성 >> 스트림으로 변환 
 	2. List 생성 >> 스트림으로 변환 
 	3. generate 메서드 >> 스트림 생성 
 	4. 범위 지정 >> 스트림 생성 
 	5. 빌더 >> 스트림 생성 
 	
 	=== 중간(가공) 절차 ===
 	1. map(Function)
 	2. filter(Predicate)
 	3. sorted(Comparator)
 	
 	=== 최종(결과) 절차 ===
 	1. collect >> stream 을 list 로 변환 
 	2. forEach >> 반복자 
 */

public class StreamMain {
	public static void main(String[] args) {

		// 1. 배열로부터 스트림 생성
		Stream<Integer> st1 = Arrays.stream(new Integer[] { 1, 2, 3, 4, 5 });

		// map(중간 연산): 각 요소를 주어진 함수에 따라 변환
		List<Integer> st1Stream = st1.map(n -> n * 2)
				// peek(중간 연산): 중간에 각 요소를 소비, 디버깅 시 유용하게 사용
				.peek(n -> System.out.print(n)) // 246810
				// collect(최종 연산): 스트림 데이터를 다른 컬렉션이나 데이터 형식으로 변환
				// Collectors.toList()로 리스트 변환을 가장 많이 사용
				.collect(Collectors.toList());

		System.out.println();
		st1Stream.forEach(n -> System.out.println("n: " + n));

		
		
		// 2. 컬렉션(List)로 부터 스트림 생성
		List<Integer> numberList = Arrays.asList(20, 30, 40, 50, 10);
		Stream<Integer> numberStream = numberList.stream();

		List<Integer> filteredList = numberStream
				.map(n -> n / 2)
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("컬렉션으로부터 스트림 생성");
		filteredList.forEach(n -> System.out.println("n: " + n)); // n: 10 n: 20
		
		
		List<Integer> sortedList = numberList.stream()
				.sorted((n1, n2) -> n1 - n2)
				.collect(Collectors.toList());
		
		System.out.println("컬렉션으로부터 스트림 생성 - sorted 메서드");
		sortedList.forEach(n -> System.out.print("n: " + n));
		

		
		// 3. Stream.generate() 메서드로 스트림 생성
		// : 무한 스트림 생성 가능
		// >> 제한 조건을 주어 사용 가능
		Stream<Double> randomStream = Stream.generate(Math::random).limit(5);

		// 4. 범위 지정 스트림 생성
		// : 특정 범위를 지정하여 스트림 생성
		IntStream rangeStream = IntStream.range(1, 10);

		
		
		// 5. 빌더를 이용한 스트림 생성
		// : 빌더 패턴을 사용하여 스트림 생성
		Stream<String> nameStream = Stream.<String>builder()
				.add("홍길동")
				.add("홍길서")
				.add("홍길남")
				.add("홍길북")
				.build();
		
		// nameStream.sorted().forEach(name -> System.out.println("name: " + name));
		
		System.out.println("빌더를 이용한 스트림 생성");
		nameStream.sorted((name1, name2) -> String.CASE_INSENSITIVE_ORDER.compare(name2, name1)) 
		// CASE_INSENSITIVE_ORDER.compare: 대소문자 구분없이 정렬 
		.forEach(name -> System.out.println("name: " + name));
		
		
		
		
		// Phone 클래스를 사용한 리스트 생성 + 스트림 API 사용 
		
		// == 리스트를 한 번에 생성하는 메서드 ==
		// cf) Arrays.asList(1, 2, 3, 4, 5) 
		// : 배열을 리스트로 변환하는 메서드 
		// >> 원소 추가 삭제 X, set 사용 O
		// +) set 메서드: set(a, b) - a번째 인덱스에 b의 값을 할당 
		List<Number> asList = Arrays.asList(1, 2, 3);
		
		// cf) List.of()
		// : 자바9부터 지원 
		// >> List 인터페이스의 디폴트 메서드인 정적 팩토리 메서드 
		// >> 원소 추가 삭제 X, set 사용 X 
		List<Number> listOf = List.of(1, 2, 3);
		
		// asList.add(1); -Error
		// listOf.add(1); -Error
		
		asList.set(0, 3);
		System.out.println(asList); // [3, 2, 3]
		
		// listOf.set(0, 3); -Error
		
		
		List<Phone> phoneList = List.of(
				Phone.builder().number(1).model("아이폰 16").build(),
				Phone.builder().number(2).model("아이폰 17").build(),
				Phone.builder().number(3).model("아이폰 18").build(),
				Phone.builder().number(4).model("아이폰 19").build()
				);
		
		phoneList.stream()
			.map(phone -> phone.builder()
					.number(phone.getNumber() * 2)
					.model(phone.getModel())
					.build())
			.forEach(phone -> System.out.println(phone));
		
		
		System.out.println("filter를 사용한 필더링");
		phoneList.stream()
			.filter(phone -> phone.getNumber() % 2 != 0)
			.forEach(phone -> System.out.println(phone));
		
		
		System.out.println("sorted를 사용한 정렬");
		List<Phone> sortedPhoneList = phoneList.stream()
			.sorted((phone1, phone2) -> phone2.getNumber() - phone1.getNumber())
			.collect(Collectors.toList());
		
		sortedPhoneList.forEach(phone -> System.out.println(phone));
	}

}
