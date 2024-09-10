package chapter13;

public class SingletonMain {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton); // chapter13.Singleton@24d46ca6(주소값) 
		
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2); // chapter13.Singleton@24d46ca6(참조값이 같다)
		
		if(singleton == singleton2) {
			System.out.println("동일한 인스턴스");
			// 동일한 인스턴스
		}else {
			System.out.println("다른 인스턴스");
		}
	}

}
