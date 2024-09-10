package otherPackage;

// import 패키지명.클래스명; 
import chapter07.Example;

public class OtherClass {
	public static void main(String[] args) {
		// 외부 패키지 클래스를 사용한 객체 인스턴스 화
		Example example = new Example();
		
		System.out.println(example.publicVar);
		// System.out.println(example.protectedVar);
		// System.out.println(example.defaultVar);
		// System.out.println(example.privatevar);
		
		example.ex1();
		// example.ex2();
		// example.ex3();
		// example.ex4();
		
	}

}
