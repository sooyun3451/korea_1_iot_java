package chapter19;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// 람다표현식(Lambda Expression)
// : 자바 8에서 도입된 함수형 프로그래밍 스타일의 표현식 
// >> 익명 함수를 간결하게 표현하는 방법(가독성, 간결성 향상)

// === 람다의 기본 형식 ===
// (매개변수) -> { 실행할 코드 }

// === 람다 예시 ===

// 1. 매개변수, 반환값이 없는 람다 
// () -> System.out.println("Hello, Lambda!");

// 2. 매개변수가 하나인 람다 
// x -> x * x;

// 3. 매개변수가 두개 이상인 람다 
// (a,b) -> a + b;

// === 자바의 함수형 인터페이스 ===
// 1. Runnable
// : 반환값이 없는 작업을 실행할 때 사용 

// 2. Comparator<T>
// : 두 객체를 비교하는 메서드를 정의하는 인터페이스 

// 3. Function<T, R>
// : 입력값을 받아 다른 타입의 결과값을 반환하는 함수형 인터페이스 

// 4. Predicate<T>
// :  조건을 검사하는 역할 
// >> 주로 stream API와 결합 

// 5. Supplier<T>
// : 매개변수를 받지 않고 단순히 무언가를 반환하는 작업 

// 6. Consumer<T> 
// : 하나의 매개변수를 받고 아무 결과도 반환하지 않는 작업 

public class Lambda01 {
	public static void main(String[] args) {
		
		
		
		// Runnable 
		Runnable r = () -> {
			System.out.println("프로그램 실행");
			// run() 생략 
		};
		// 반환이 없는 인터페이스의 실행 
		r.run(); // 프로그램 실행
		
		
		
		// Comparator 
		Comparator<Integer> comparator = (x, y) -> x - y;
		// 두가지 객체를 비교하여 나온 결과값으로 오름차순 정렬 
		System.out.println(comparator.compare(10, 20)); // -10
		
		List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 7);
		Collections.sort(numbers, comparator);
		System.out.println(numbers); // [1, 2, 3, 5, 7, 8]
		
		
		
		// Function
		// 문자열을 정수로 변환하는 람다 표현식 
		Function<String, Integer> fx = s -> Integer.parseInt(s);
		
		// Function의 함수를 실행하는 apply 메서드 
		Integer num = fx.apply("10");
		System.out.println(num); // 10
		
		// +) andThen 메서드: 사용 후 반환값을 활용 
		Integer num2 = fx.andThen(result -> result + 100) // 그리고 나서 100을 더함 
				.apply("10"); // 문자열 10을 정수로 변경 
		System.out.println(num2); // 110
		
		
		
		// Predicate
		Predicate<Integer> even = n -> n % 2 == 0;
		
		// >> test 메서드로 검사 
		System.out.println(even.test(10)); // true
		System.out.println(even.test(11)); // false
		
		
		
		// Supplier
		Supplier<Integer> role = () -> {
			Integer result = num + 999; // num(10)
			return result;
		};
		
		// >> get 메서드로 반환값 출력 
		System.out.println(role.get()); // 1009
		
		
		
		// Consumer
		Consumer<String> transform = s -> {
			System.out.println(s + " 서버에 접속 완료"); // 홍길동 서버에 접속 완료
			System.out.println(s + "님 환영합니다."); // 홍길동님 환영합니다.
		};
		
		// >> accept 메서드 실행으로 인자 전달 
		transform.accept("홍길동");
		
		
	}

}
