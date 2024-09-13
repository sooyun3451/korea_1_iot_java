package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 API
// : 컬렉션 데이터를 효율적으로 처리할 수 있는 기능을 제공 
// >> 람다표현식과 결합하여 직관적이며 간결한 코드 작성 

// cf) Arrays.asList();
// : 일반 배열을 ArrayList로 반환 
// >> 원소를 추가하는 메서드를 가지고 있지 X, 사이즈를 바꿀수 X

// ## java.util.ArrayList와 다른 클래스 

// === 특징 ===
// - 컬렉션(Collection) 데이터를 간결하고 효율적으로 처리 
// - 데이터를 필터링, 매핑, 축소 등의 작업을 용이하게 수행 
// - 함수형 프로그래밍 기법과 함께 사용 

// 1. 데이터 파이프 라인
// : 스트림은 데이터를 소스로부터 연속적으로 처리하는 파이프라인을 구축 
// 2. 데이터 변경X
// : 스트림은 원본 데이터 변경 X, 새로운 값을 반환 
// 3. 지연 처리 
// : 중간 처리가 지연되어 최종 처리가 호출될 때 한 번에 처리 

// === 스트림 API의 기본 구성 요소 ===
// 1. 소스(Source) 
// : 스트림을 생성하는 단계 
// >> 컬렉션, 배열 또는 파일을 소스로 사용 

// 2. 중간 연산 
// : 데이터를 필터링, 매핑(변환)하는 과정 
// >> 연산을 연속적으로 사용 가능 
// >> 스트림은 새로운 스트림을 반환 

// 3. 최종 연산 
// : 모든 데이터를 처리한 후 결과를 반환하거나 출력하는 연산 

public class D_Stream01 {
	public static void main(String[] args) {
		// 기본적인 스트림 처리 예시 
		// 1. 리스트에서 짝수만 필터링하고 정렬한 후 출력 
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// [1, 2, 3, 4, 5, 6]
		// >> 짝수만 출력
		
		// 기존 방식 (for, if 문 사용) 
		for(Integer number: numbers) {
			if(number % 2 == 0) {
				System.out.print(number);
			}
		}
		System.out.println(); // 줄바꿈 
		
		// 람다표현식 & 스트림API 
		numbers.stream()
			.filter(number -> number % 2 == 0)
			.forEach(System.out :: print); // 246
		
		System.out.println(); // 줄바꿈 
		
		// === 스트림 API 기본 사용법 ===
		// 1. 스트림 생성 
		List<String> names = Arrays.asList("홍길동", "홍길서", "최소윤");
		
		// cf) .stream()으로 생성된 스트림은 일회성 사용만 가능!
		// >> 한 번 사용한 스트림은 재사용 할 수 X
		Stream<String> stream = names.stream();
		
		// 2. 중간 연산 
		// 	: 여러개를 체인처럼 연결하여 사용 가능 
		Stream<String> filteredStream = stream.filter(name -> name.startsWith("홍"));
		
		
		// 3. 최종연산 
		// : 처리를 완료하고 결과를 반환하거나 특정 작업을 수행 
		filteredStream.forEach(System.out::print); // 홍길동홍길서
		
		Stream<Integer> lengthStream = names.stream().map(String::length);
		System.out.println(); // 줄바꿈 
		lengthStream.forEach(System.out::print); // 333
		
		
		// cf) 최종 연산 시 스트림의 결과를 컬렉션으로 변환: collect()
		List<String> filteredNames = names.stream()
				.filter(name -> name.startsWith("최"))
				.collect(Collectors.toList());
		
		System.out.println(); // 줄바꿈 
		System.out.println(filteredNames); // [최소윤]
	}

}
