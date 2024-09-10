package chapter10;

import java.util.InputMismatchException;
import java.util.Scanner;

// === 사용자 정의 예외클래스 ===
// >> 자바의 Exception 클래스를 상속받는 자식 클래스 
class CustomException extends Exception {
	CustomException(String msg) {
		super(msg);
	}
}

public class Exception02 {
	public static void main(String[] args) {
		// === 사용자 정의 예외 사용 ===
		try {
			throw new CustomException("사용자 정의 예외 발생");
		} catch (CustomException e) {
			System.out.println(e.getMessage()); // 사용자 정의 예외 발생
		}
		
		System.out.println("==========");
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("정수를 입력하세요.");
			int number = scanner.nextInt();
			System.out.println("입력하신 숫자는" + number + "입니다.");
		} catch (InputMismatchException e) {
			System.out.println("정수가 아닌 다른 타입의 입력이 작성됨");
			// e.getMessage()
			// : 위의 결과값이 null인 경우 해당 예외에 대한 메시지가 담겨있지 X 
		} finally {
			scanner.close();
		}

	}

}
