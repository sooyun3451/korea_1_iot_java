package chapter20.library;

import java.util.List;

public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(String title, String author, int year) {
		Book book = new Book(title, author, year);
		bookRepository.save(book);
	}

	public void updateBook(int id, String title, String author, int year) {
		Book book = bookRepository.findById(id);
		if(book != null) {
			book.setTitle(title);
			book.setAuthor(author);
			book.setYear(year);
			bookRepository.save(book);
		} 
	}

	public void deleteBook(int id) {
		bookRepository.delete(id);
	}

	public Book getBook(int id) {
		return bookRepository.findById(id);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
