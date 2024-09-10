package chapter01;

import java.util.Scanner;

public class D_IO {
//	class 내부의 실행을 담당하는 메인 메서드
//	: main + 자동완성(ctrl + space)
	public static void main(String[] args) {
		// 자바 기본 입출력
		// 입력: 콘솔창을 통해 개발자로부터 입력을 받는 것
		// 출력: 콘솔창으로 데이터를 출력하는 것
		
		// 1. 출력 
//		System.out.println(출력하고자하는 변수 또는 상수 또는 데이터값);
//		syso 단축키로 자동 완성
		
		System.out.println("안녕하세요");
		System.out.println("반갑습니다");
		// >> 주어진 값을 콘솔에 출력하고 줄을 바꿈
		// ln: line (줄바꿈)
		
		System.out.print("안녕");
		System.out.print("하세요"); 
		
		System.out.println("!!!"); // 안녕하세요!!!
		
		// cf) 자바의 출력은 문자열 사용 시 쌍 따옴표로 지정
		
		// 2. 입력
		// Scanner 객체 사용
		// : 다양한 입력 소스로부터 데이터를 읽어올 수 있는 형태
		
		// >> System.in: 콘솔 창에서 표준 입력 스트립을 사용
		
		// import java.util.Scanner;
		// >> 자바 내장 객체인 Scanner를 사용
		// new Scanner(데이터를 받아올 형식)
		
		
		Scanner sc = new Scanner(System.in);
		
		// 스캐너 사용 방법
//		sc.next(); // 입력 내용을 문자열로 반환
//		sc.nextLine(); // 엔터까지의 전체 라인을 문자열로 반환
//		sc.nextInt(); // 정수 데이터
//		sc.nextDouble(); // 실수 데이터
		
		System.out.println("정수를 입력해주세요.");
		int age = sc.nextInt();
//		sc.nextLine();
		System.out.println("입력한 나이: " + age);
		
		// cf) 개행 문자 + 버퍼
		// : nextInt()나 nextDouble()의 경우 
		// >> 버퍼에 개행 문자가 입력으로 처리되는 문제가 발생
		// >> 위의 메서드 사용 후 
		//    , nextLine()의 입력 메서드 호출로 버퍼의 데이터를 사용
		
		System.out.print("키를 입력하세요: ");
		int height = sc.nextInt(); // 정수 입력
		
//		버퍼에 남아있는 개행 문자(Enter)를 처리
		sc.nextLine(); 
		
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		
		// 스캐너 종료 방법
//		: 스캐너 사용 후 메모리 최적화를 위해 스캐너를 종료
//		>> .close()
		sc.close();
		
//		sc.next(); // - Error
		
		
	}
}