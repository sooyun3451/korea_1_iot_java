package chapter12.model;

// 순수한 클래스 (실행 main 메서드X)

// 책 객체를 정의하는 클래스 
// : 제목, 저자, 출판사 

public class Book {
	// 인스턴스 변수
	private String title;
	private String author;
	private String publisher;

	// 생성자
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	// getter 메서드
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}
	
	// object 안에 있는 toString()메서드 재정의 
	@Override
	public String toString() {
		return "Title: " + title + " Author: " + author + " Publisher: " + publisher;
	}
}
