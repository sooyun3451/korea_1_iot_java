package chapter05;

class BaseballPlayer {
	// 인스턴스 변수 
	// 선수 이름(name - 문자열), 타율(battingAverage - 실수), 홈런 수(homeRun - 정수) 
	String name;
	double battingAverage;
	int homeRun;
	
	// 정적(클래스) 변수 
	// : 생성된 선수의 총 인원(playerCount - 정수)
	// >> 모든 인스턴스에서 공유 
	static int playerCount; 
	
	// 생성자 >> 인스턴스 변수 초기화 & 정적 변수 후위 증가(변수명++) 
	BaseballPlayer(String name, double battingAverage, int homeRun) {
		// 인스턴스 변수 = 매개변수 값 
		this.name = name;
		this.battingAverage = battingAverage;
		this.homeRun = homeRun;
		playerCount++; // 선수 생성 시 전체 수 증가 
	}
	
	// 인스턴스 메서드 
	// 선수의 타율과 홈런 수를 업데이트하는 메서드 
	// >> 매개변수로 newBattingAverage, newHomeRuns를 받아 기존의 인스턴스 변수에 재할당 
	void updateStatus(int newBattingAverage, int newHomeRuns) {
		// 인스턴스 변수 = 매개변수값; 
		battingAverage = newBattingAverage;
		homeRun = newHomeRuns;
	}
}

public class MethodPractice {
	public static void main(String[] args) {
		// 인스턴스 생성 
		BaseballPlayer player1 = new BaseballPlayer("홍길동", 0.325, 16);
		BaseballPlayer player2 = new BaseballPlayer("홍길서", 0.293, 7);
		BaseballPlayer player3 = new BaseballPlayer("홍길남", 0.301, 11);
		BaseballPlayer player4 = new BaseballPlayer("홍길북", 0.274, 3);
		
		System.out.println("총 생성된 선수의 수: " + BaseballPlayer.playerCount); // 총 생성된 선수의 수: 4
	}
}
