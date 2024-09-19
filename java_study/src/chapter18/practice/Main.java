package chapter18.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// === 빌더 패턴 예제 ===

// 1) Product 클래스: 제품에 대한 정보 (상품 이름, 가격, 설명 등)
// 2) Customer 클래스: 고객에 대한 정보 (고객 이름, 이메일, 배송 주소 등)
// 3) Order 클래스: 주문에 대한 정보 (주문 아이디, 제품 목록, 고객 정보, 총 금액 등)

// 메인클래스 
public class Main {
	public static void main(String[] args) {
		// 1. Product 객체 생성 
		Product pd1 = Product.builder()
				.name("상성 북 4")
				.price(1200.10)
				.description("삼성 북 시리즈의 네번째 모델")
				.build();
		
		Product pd2 = Product.builder()
				.name("갤럭시 s24")
				.price(670.50)
				.description("삼성 핸드폰")
				.build();
		
		// 2. Customer 객체 생성(중첩된 Address 객체 포함)
		Customer.Address address1 = Customer.Address.builder()
				.street("전포대로")
				.city("부산")
				.postalCode("12345")
				.build();
		
		Customer customer1 = Customer.builder()
				.name("홍길동")
				.email("hong@gmail.com")
				.address(address1)
				.build();
		
		// 3. Order 객체 생성 
		List<Product> products = Arrays.asList(pd1, pd2);
		double totalPrice = Order.calculateTotalPrice(products);
		
		System.out.println(totalPrice); // 1870.6
		
		Order order = Order.builder()
				.orderId("ORD123")
				.customer(customer1)
				.products(products)
				.totalPrice(totalPrice)
				.build();
		
		System.out.println(order);
		// Order(orderId=ORD123, customer=Customer(name=홍길동, email=hong@gmail.com, address=Customer.Address(street=전포대로, city=부산, postalCode=12345)),
		// products=[Product(name=상성 북 4, price=1200.1, description=삼성 북 시리즈의 네번째 모델), Product(name=갤럭시 s24, price=670.5, description=삼성 핸드폰)], 
		// totalPrice=1870.6)
		
	}

}
