package chapter19;

public class ModificationMain {
	public static void main(String[] args) {
		// 익명클래스를 사용하여 Modification 인터페이스 구현 
		Modification<String> m1 = new Modification<String>() {
			@Override
			public String modify(String oldData, String newData) {
				System.out.println("기존 데이터: " + oldData); // 기존 데이터: 홍길동
				System.out.println("새로운 데이터: " + newData); // 새로운 데이터: 홍길서
				return newData + "1";
			}
		};
		
		
		Modification<String> m2 = new Modification<String>() {
			@Override
			public String modify(String oldData, String newData) {
				return newData + "2";
			}
		};
		
		// 람다표현식으로 Modification 인터페이스 구현 
		// - 람다표현식은 익명 클래스를 간결하게 표현 
		// - 매개변수의 타입 생략이 가능 
		Modification<String> m3 = (oldData, newData) -> newData + "3";
		
		// === , modify 메서드 실행 ==
		String name = "홍길동";
		String newName = m1.modify(name, "홍길서");
		System.out.println(newName); // 홍길서1
		
		String newName2 = m2.modify(name, "홍길남");
		System.out.println(newName2); // 홍길남2
		
		String newName3 = m3.modify(newName, "홍길북");
		System.out.println(newName3); // 홍길북3	
	}

}
