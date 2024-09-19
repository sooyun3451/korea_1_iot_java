package chapter18.practice;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

// 주문클래스 
// 한명의 고객(Customer) 
// 여러개의 제품(Product)
@Builder
@Getter
@ToString
public class Order {
	private final String orderId; // 주문 고유 번호 
	private final Customer customer;
	private final List<Product> products;
	private final double totalPrice; // 제품 총 가격 
	
	// 총 금액을 계산하는 메서드 
	public static double calculateTotalPrice(List<Product> products) {
		// 리스트 프레임워크 데이터를 순회하여 Double 타입의 데이터로 반환 
		return products.stream().mapToDouble(Product::getPrice).sum();
		
		// (Product product) -> { product.getPrice() } - 람다(Lambda)
		// product -> product.getPrice()
		// Product::getPrice
	}
}
