package chapter05;

// 음식점 클래스 
// : 다양한 방법으로 주문을 받는 메서드 정의 
class Restaurant {
	// 메서드 정의 
	// : placeOrder 주문 메서드 
	// >> 메뉴 이름 (String dish) 
	// >> 메뉴 이름, 수량 제공(int quantity)
	// >> 메뉴 이름, 특별 요청 사항 제공(String specialRequests)
	// >> 메뉴 이름, 수량 제공, 특별 요청 사항 제공 
	
	// >> 각 메서드에서 매개변수의 데이터 값을 출력 
	
	String dish;
	int quantity;
	String specialRequests;
	
	void placeOrder(String dish) {
		System.out.println("메뉴:" + dish);	
	}
	
	void placeOrder(String dish, int quantity) {
		System.out.println("메뉴:" + dish + "수량:" + quantity);
	}
	
	void placeOrder(String dish, String specialRequests) {
		System.out.println("메뉴:" + dish + "특별 요청 사항 제공: " + specialRequests);
	}
	
	void placeOrder(String dish, int quantity, String specialRequests) {
		System.out.println("메뉴:" + dish + "수량:" + quantity + "특별 요청 사항: " + specialRequests);
	}
}

public class Overloading02 {
	public static void main(String[] args) {
		
		// 인스턴스 생성 
		Restaurant restaurant = new Restaurant();
		restaurant.placeOrder("햄버거");
		restaurant.placeOrder("햄버거", 19);
		restaurant.placeOrder("햄버거", "1시까지 맛있게 먹게 해주세요!");
		restaurant.placeOrder("햄버거", 19, "1시까지 맛있게 먹게 해주세요!");
	}

}
