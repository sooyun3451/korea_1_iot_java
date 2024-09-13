package chapter15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; // List 컬렉션 프레임워크

public class Member {
	private String memberId;
	private String name;
	private List<Loan> loans; // 대여 목록
	
	// 생성자
	public Member(String memberId, String name) {
		this.memberId = memberId;
		this.name = name;
		this.loans = new ArrayList<Loan>();
	}
	
	// 책 대여 메서드
	public void borrowBook(Book book) throws BookAlreadyBorrowedException {
		book.borrowBook(); // 책 대여 시도
		
		// cf) this 키워드
		// : 인스턴스화 된 객체 (실제 데이터)
		Loan loan = new Loan(this, book, LocalDate.now()); // 대여 기록 생성
		loans.add(loan); // 대여 목록에 추가
		System.out.println(name + "회원이 " + book.getTitle() + "(을)를 대여하였습니다.");
	}
	
	// 책 반납 메서드
	public void returnBook(Book book) {
		book.returnBook(); // 책 반납 시도
		// removeIf()
		// : 리스트 메서드, 조건을 만족하는 요소를 리스트에서 제거, 조건은 람다식을 사용하여 정의
		loans.removeIf(loan -> loan.getBook().equals(book)); // 대여 목록에서 제거
		System.out.println(name + "회원이 " + book.getTitle() + "(을)를 반납하였습니다.");
	}	
}