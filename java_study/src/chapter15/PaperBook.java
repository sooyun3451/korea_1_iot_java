package chapter15;

// == 상속 & 다형성 ==
// 도서(Book) 클래스를 상속받는 전자책(EBook), 종이책(PaperBook) 클래스 정의
public class PaperBook extends Book {
	private int numberOfPages; // 페이지 수
	
	// 생성자
	public PaperBook(String title, String author, String isbn, int numberOfPages) {
		super(title, author, isbn); // 상위 클래스(Book)의 생성자 호출
		this.numberOfPages = numberOfPages;
	}
	
	// 종이책 대여 시 안내 메시지 출력
	@Override
	public void borrowBook() throws BookAlreadyBorrowedException {
		super.borrowBook();
		System.out.println("종이책은 물리적 대여만 가능합니다.");
	}
}