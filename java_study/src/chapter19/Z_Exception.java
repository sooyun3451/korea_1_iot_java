package chapter19;

// 예외처리 

// cf) 예외: 프로그램 실행 중 발생하는 비정상적인 상황 

// cf) 예외 종류: 체크 예외(컴파일 시점) / 언체크 예외(런타임 시점에 발생)

// +) 예외 클래스의 계층 구조 
/*
 	Throwable 
 	>> Error (시스템 레벨 오류) 
 	>> Exception 
 		>> Checked 
 		>> Unchecked 
 */

// 1. 예외 처리 구문 
// try-catch 블록 
// finally 블록 

// 2. 기타 예외 처리 키워드 

// 1) throws 키워드 - 메서드 선언부에 사용하여 예외를 호출한 메서드로 전파 
//public void someMethod() throws IOException {
//}

// 2) throw 키워드 - 예외 객체를 명시적으로 발생시키는데 사용 
// throw new IOException("파일을 찾을 수 없습니다.");

// 3. 사용자 정의 예외 
class CustomException extends Exception {
	public CustomException(String message) {
		super(message);
	}
}

public class Z_Exception { 
	public static void validate(int age) throws CustomException {
		if(age < 18) {
			throw new CustomException("나이는 18세 이상이어야 합니다.");
		}
	}
	
	public static void main(String[] args) {
		try {
			Z_Exception.validate(17);
		} catch(CustomException e) {
			
			// 1. printStackTrace();
			// : 예외가 발생했을 때 예외의발생 경로와 관련된 스택 트레이스를 출력하는 메서드 
			// >> 예외가 발생한 위치와 예외가 전파된 경로를 포함하여 상세 정보를 출력 
			e.printStackTrace();
			
			// 2. getMessagge()
			// : 예외 객체에 저장된 예외 메시지를반환하는 메서드 (출력X) 
			// >> 문자열 반환 - 출력하고자 하는 경우 System.out.println로 출력 
			System.out.println(e.getMessage()); // 나이는 18세 이상이어야 합니다.
		}
		System.out.println("정상적인 로직");
	}

}
