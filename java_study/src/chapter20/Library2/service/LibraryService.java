package chapter20.Library2.service;

import chapter20.Library2.model.Book;
import chapter20.Library2.model.User;
import chapter20.Library2.repository.BookRepository;
import chapter20.Library2.repository.UserRepository;

public class LibraryService {
	private BookRepository bookRepository = new BookRepository();
	private UserRepository userRepository = new UserRepository();

	public void addBook(Book book) {
		bookRepository.addBook(book);
	}

	public void registerUser(User user) {
		userRepository.addUser(user);
	}

	public void borrowBook(String userId, String bookTitle) {
		User user = userRepository.findUserById(userId);
		Book book = bookRepository.findBookByTitle(bookTitle);
		
		if(user != null && book != null && !book.isBorrowed()) {
			// 책을 대여할 수 있는 상태 
			book.setBorrowed(true);
			System.out.println(user.getName() + "님이" + book.getTitle() + "을(를) 대여하였습니다.");
		}else {
			// 책을 대여할 수 없는 상태 
			System.out.println("대여불가: 사용자가 존재하지 않거나 도서가 이미 대여 중입니다.");
		}
	}

	public void returnBook(String title) {
		Book book = bookRepository.findBookByTitle(title);
		
		if(book != null && book.isBorrowed()) {
			book.setBorrowed(false);
			System.out.println(book.getTitle() + "이(가) 반납되었습니다.");
		}else {
			System.out.println("반납 불가: 해당 도서는 대여 중이 아닙니다.");
		}
	}

	public void listAllBooks() {
		for(Book book: bookRepository.findAllBooks()) {
			System.out.println(book.getTitle() + " - " + (book.isBorrowed() ? "대여 중" : "대여 가능"));
		}
	}
	
	public void listAllUsers() {
		for(User user: userRepository.findAllUsers()) {
			System.out.println(user.getUserId() + ": " + user.getName());
		}
	}

}
