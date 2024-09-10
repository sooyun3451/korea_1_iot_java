package chapter04;

//클래스 생성 (Book, Person,...)
// : 속성 2개 
// : 메서드1개 
class Book {
	
	// 클래스 내부의 데이터(속성) 
	String title;
	String author;
	
	// 클래스 내부의 동작(메서드) 
	void read() {
		System.out.println(title + "를 읽습니다");
	}
	
	// === 생성자 함수 ===
	// : new 연산자 사용 시 호출 될 메서드 
	// >> 생략 시 속성에 기본값이 할당 
	// 일반 타입: int(0), boolean(false) char('');
	// 참조 타입: null
	
	// >> 생략 시 클래스 명과 동일하면서 매개변수가 없는 메서드 
	Book(String title, String author) { // 매개변수로 받은 데이터로 속성 초기화 
		
		// this.클래스속성 = 매개변수명;
		this.title = title;
		this.author = author;
	}
}

public class Object04 {
	public static void main(String[] args) {
		// 위에서 정의한 클래스를 사용하여 객체 인스턴스
		Book book = new Book("어린왕자", "생텍쥐페리");
		Book anotherBook = new Book("셜록홈즈", "아서코난도일");
		
		// 속성 출력 
		System.out.println(book.title); // 어린왕자 
		System.out.println(book.author); // 생텍쥐페리 
		
		System.out.println(anotherBook.title); // 셜록홈즈 
		System.out.println(anotherBook.author); // 아서코난도일 
		
		// 메서드 호출 
		book.read(); // 어린왕자를 읽습니다
		anotherBook.read(); // 셜록홈즈를 읽습니다
		
		book.title = "라푼젤";
		System.out.println(book.title); // 라푼젤
	}
}
