package chapter04;

class Card {
	// 인스턴스 변수: 각 카드마다 고유의 속성(개별 속성)
	// >> 일반 변수 선언과 동일 
	int number;
	String kind;
	
	// 클래스 변수: 모든 카드가 공유할 데이터 
	static int width = 100;
	static int height = 250;
}

public class ClassPractice {
	public static void main(String[] args) {
		// 정적(클래스) 변수 
		System.out.println(Card.width); // 100
		System.out.println(Card.height); // 150
		
		// System.out.println(Card.kind); - Error
		
		// 클래스 Card의 객체(인스턴스) 생성 
		Card c1 = new Card();
		c1.kind = "Spade";
		c1.number = 7;
		System.out.println(c1.kind + c1.number);
		
		//System.out.println(c1.width);
		// >> 인스턴스를 통한 클래스 변수에 접근은 가능하지만 인스턴스 변수와의 혼돈을 막기위해 클래스명으로 호출을 권장 
		
	
		
	}

}
