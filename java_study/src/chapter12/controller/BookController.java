package chapter12.controller;

import java.util.ArrayList;
import java.util.List;
import chapter12.model.Book;

// Book 데이터를 사용하여 기능 정의 

public class BookController {
	// 인스턴스 변수 생성
	private List<Book> books;

	// 생성자
	// >> 책(객체)을 담을 리스트 생성
	public BookController() {
		this.books = new ArrayList<Book>();
	}

	// 1. 책을 추가하는 기능
	public void addBook(String title, String author, String publisher) {
		Book newBook = new Book(title, author, publisher);
		books.add(newBook);
	}

	// 2. 책 리스트 반환
	public List<Book> getAllBooks() {
		return books;
	}

	// 3. 도서 검색 기능
	public List<Book> searchBook(String title) {
		// 검색된 도서를 담을 리스트
		List<Book> result = new ArrayList<Book>();

		// books 배열을 순환하여 각 순환마다 해당 요소를 Book타입의 변수의 반환
		// >> for-each 문
		for (Book book : books) {
			if(book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		return result;
	}

}
