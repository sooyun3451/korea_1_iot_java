package chapter14.view;

import java.util.Scanner;

public class OrderView {
	// 사용자로부터 주문을 받는 로직 
	private Scanner scanner = new Scanner(System.in);
	
	// 메뉴 선택을 사용자에게 요청하는 메서드 
	public String getUserChoice() {
		System.out.println("=======");
		System.out.println("Select an option");
		System.out.println("1. Pizza");
		System.out.println("2. Pasta");
		System.out.println("3. Coke");
		System.out.println("4. Ade");
		System.out.print("Your Choice: ");
		return scanner.nextLine();
	}
	
	// 주문 수량을 사용자에게 요청하는 메서드 
	public int getQuantity() {
		System.out.println("Enter Quantity");
		int quantity = scanner.nextInt();
		scanner.nextLine();
		return quantity;
	}
	
	// 총 주문 가격을 표시하는 메서드 
	public void displayTotalPrice(int price) {
		System.out.println("Total price: " + price + " KRW");
	}
	
	// 주문 완료 메시지 표시 메서드 
	public void displayOrderComplete() {
		System.out.println("Order has been completed");
	}

}
