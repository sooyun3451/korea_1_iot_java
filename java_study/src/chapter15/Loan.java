package chapter15;

// 컴퓨터의 현재 "날짜" 정보
import java.time.LocalDate;

public class Loan {
	private Member member; // 대여한 회원
	private Book book; // 대여한 책
	private LocalDate loanDate; // 대여 날짜
	private LocalDate returnDate; // 반납 날짜
	
	// 생성자
	public Loan(Member member, Book book, LocalDate loanDate) {
		this.member = member;
		this.book = book;
		this.loanDate = loanDate;
		this.returnDate = null; // 반납 날짜 - 추후 지정
	}
	
	// getter 메서드
	public Member getMember() { 
		return member; 
	};
	public Book getBook() { 
		return book; 
	};
	public LocalDate getLoanDate() { 
		return loanDate; 
	};
	public LocalDate getReturnDate() { 
		return returnDate;
	};
	
	// 반납 날짜 설정 (setter)
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	// 도서 연체 여부를 확인하는 메서드
	public boolean isOverdue() {
		return returnDate == null && loanDate.plusDays(14).isBefore(loanDate.now());
		// returnDate가 null인 경우: 아직 반납되지 않음
		// loanDate.plusDays(14).isBefore(loanDate.now()): 대여일로부터 14일이 지남
		// >> loanDate.plusDays(14): 대여 날짜 + 14일 
		// >> loanDate.now(): 현재 날짜
		// >> A.isBefore(B)
		//    : 현재 날짜가 대여 기한 보다 늦은 날짜라면 true (연체됨)
		//    : A가 B보다 이전 날짜(A가 9월 15일, B가 9월 17일)
	}
}