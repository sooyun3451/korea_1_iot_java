package chapter15;

// 도서(Book) 클래스 정의
public class Book {
	private String title;
	private String author;
	private String isbn; // ISBN - 공용 책 고유 번호
	private boolean isAvailable;
	
	// 생성자
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isAvailable = true; // 기본값) 대여 가능 상태
	}
	
	// 책 대여 메서드
	// : 책이 대여 중일 경우 오류 발생
	// : 대여 시 isAvailable을 false 설정
	
	// cf) 메서드명 옆의 throws 키워드
	// : 해당 메서드가 특정 예외를 던질 수 있음을 나타냄(가능성)
	
	// >> 해당 메서드가 throws 예외를 던질 수 있으니 해당 메서드를 호출한 쪽에서
	//    , 해당 예외를 처리하도록 명시한 내용
	public void borrowBook() throws BookAlreadyBorrowedException {
		if (!isAvailable) {
			throw new BookAlreadyBorrowedException(this.title + "(은)는 이미 대여 중입니다.");
		}
		isAvailable = false; // 대여 중으로 설정
		System.out.println(title + "(이)가 대여되었습니다.");
	}
	
	// 책 반납 메서드
	// : 반납 시 isAvailable을 true 설정
	public void returnBook() {
		isAvailable = true; // 다시 대여 가능 상태로 변경
		System.out.println(title + "(이)가 반납되었습니다.");
	}
	
	// getter 메서드
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public boolean isAvaliable() {
		return isAvailable;
	}
}