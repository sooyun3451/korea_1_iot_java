package chapter20.library;

// 도서관리시스템 
// : 순수한 자바를 사용하여 스프링 프레임워크와 유사함 체계로 설계 
// >> 도서의 등록, 조회, 수정, 삭제 (CRUD) 기능을 제공 

// === 프로젝트 요구사항 ===
// 1. 계층 구조: 스프링프레임워크의 MVC 패턴 사용 
// Controller: 사용자 요청을 처리하고 서비스로 전달 
// Service: 비즈니스 로직 처리 
// Repository: 데이터 저장소 역할, 도서 정보를 메모리에 저장 

// 2. 기능 
// 도서 등록, 조회, 수정, 삭제, 전체 목록 조회 

// BookController 
// BookService
// BookRepository
// Book: 도서의 데이터를 관리하는 클래스 

public class Main {
	public static void main(String[] args) {
		BookRepository bookRepository = new BookRepository();
		BookService bookService = new BookService(bookRepository);
		BookController bookController = new BookController(bookService);
		
		bookController.addBook("자바 한 번에 끝내기", "홍길동", 2023);
		bookController.addBook("자바스크립트 한 번에 끝내기", "홍길서", 2020);
		bookController.addBook("리액트 한 번에 끝내기", "홍길남", 2021);
		bookController.addBook("SQL 한 번에 끝내기", "홍길북", 2024);
		
		System.out.println("== 모든 도서 목록 ==");
		bookController.getAllBooks().forEach(System.out::println);
		
		System.out.println();
		System.out.println("==  특정 id 도서 조회 ==");
		Book book = bookController.getBook(1);
		System.out.println("조회한 도서: " + book);
		
		System.out.println();
		System.out.println("== 특정 id 도서 수정 ==");
		bookController.updateBook(2, "스프링 한 번에 끝내기", "최소윤", 2020);
		System.out.println("수정 후 도서: " + bookController.getBook(2));
		
		System.out.println();
		System.out.println("== 특정 id 도서 삭제 ==");
		bookController.deleteBook(2);
		bookController.getAllBooks().forEach(System.out::println);
		
		System.out.println();
		System.out.println("== 추가 후 전체 출력 ==");
		bookController.addBook("안녕하세요", "홍길서", 2022);
		bookController.getAllBooks().forEach(System.out::println);
	}

}
