package chapter20.Library;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 도서의 데이터를 관리하는 클래스 
public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
}

// @Data: Getter/Setter, ToString, Equals, HashCode를 포함 
// @NoArgsConstructor: 파라미터가 없는 기본 생성자를 생성 
// @AllArgsConstructor: 모든 필드를 받는 생성자를 자동 생성 
// @Builder: Builder 패턴 구조를 생성 
