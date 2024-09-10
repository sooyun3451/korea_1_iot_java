package chapter09;

// 추상 클래스 
// === 모바일 애플리케이션 ===
abstract class MobileApp {
	abstract void execute(); // 추상 메서드 (실행)
	
	// (일반, 구현) 메서드 
	void appInfo() {
		System.out.println("This is a mobile app");
	}
}

// === 게임 애플리케이션 === 
class GameApp extends MobileApp {
	// 추상 메서드 "구현"
	@Override
	void execute() {
		System.out.println("Game app executes");
	}	
}

// 사회 네트워킹 애플리케이션 
class SocialApp extends MobileApp {
	String name;
	
	// 생성자 
	SocialApp(String name) {
		this.name = name;
	}
	
	@Override
	void execute() {
		System.out.println(name + " app executes");
	}
	
	@Override
	void appInfo() {
		System.out.println(name +  "app is most popular social app");
	}
}

public class E_Practice {
	public static void main(String[] args) {
		// === 인스턴스 생성 ===
		MobileApp myGameApp = new GameApp();
		SocialApp mySocialApp = new SocialApp("FaceBook");
		
		myGameApp.execute(); // Game app executes
		myGameApp.appInfo(); // 추상 클래스가 가진 일반 메서드 출력 (This is a mobile app)
		
		mySocialApp.execute(); // FaceBook app executes
		mySocialApp.appInfo(); // 재정의 된 메서드 출력 (FaceBookapp is most popular social app)
		
	}

}
