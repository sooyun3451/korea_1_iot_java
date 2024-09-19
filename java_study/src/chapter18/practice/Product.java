package chapter18.practice;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

// 제품클래스 
@Builder
@Getter
@ToString
public class Product {
	private final String name;
	private final double price;
	private final String description;
}
