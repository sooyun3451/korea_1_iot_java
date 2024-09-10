package chapter14.controller;

import chapter14.model.OrderModel;
import chapter14.view.OrderView;

public class OrderController {
	private OrderModel model;
	private OrderView view;
	
	public OrderController(OrderModel model, OrderView view) {
		this.model = model;
		this.view = view;
	}
	
	// 사용자의 입력을 처리하고 주문을 관리하는 메서드 
	public void processOrder() {
		while(!model.isComplete()) {
			String userChoice = view.getUserChoice();
			switch(userChoice) {
			case "1": 
				model.addOrder("Pizza", view.getQuantity());
				break;
			case "2": 
				model.addOrder("Pasta", view.getQuantity());
				break;
			case "3": 
				model.addOrder("Coke", view.getQuantity());
				break;
			case "4": 
				model.addOrder("Ade", view.getQuantity());
				break;
			case "q": 
				model.setComplete(true);
				view.displayTotalPrice(model.calculateTotal());
				view.displayOrderComplete();
				break;
			default: 
				System.out.println("Invalid Choice, Please try again");
			}
		}
	}

}
