package chapter15;

// 사용자 정의 예외
// : 책이 이미 대여 중일 때 발생하는 예외
public class BookAlreadyBorrowedException extends RuntimeException {
	public BookAlreadyBorrowedException(String message) {
		super(message);
	}
}