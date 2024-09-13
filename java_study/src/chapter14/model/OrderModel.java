package chapter14.model;

import java.util.HashMap;
import java.util.Map;

// 음식점 메뉴 주문 시스템 
// - 사용자가 메뉴를 선택, 수량을 입력 >> 총 가격을 계산 
// - 종료 옵션을 선택할 때까지 반복하여 메뉴 선택을 받음 

// "메뉴" 객체 
// : 메뉴명 - 가격의 쌍으로 데이터 관리 
public class OrderModel {
	// 메뉴 이름(키), 가격(값)으로 하는 HashMap
	private Map<String, Integer> menuPrices;

	// 주문된(선택된) 메뉴의 이름과 키를 가지는 HashMap
	private Map<String, Integer> order;

	// 주문이 완료되었는지 여부 - boolean
	private boolean isComplete;

	public OrderModel() {
		menuPrices = new HashMap<String, Integer>();
		order = new HashMap<String, Integer>();
		isComplete = false;

		// 메뉴와 가격을 초기화
		menuPrices.put("Pizza", 22000);
		menuPrices.put("Pasta", 18000);
		menuPrices.put("Coke", 2000);
		menuPrices.put("Ade", 5000);
	}

	// === 기능 정의 ===
	// 1. 주문을 추가하는 메서드
	public void addOrder(String dish, int quantity) {
		if (menuPrices.containsKey(dish)) {
			// 주문목록에 메뉴 추가 또는 이미 존재할경우 수량을 업데이트

			// getOrDefault(key, defaultValue)
			// : 찾는 key 가 존재한다면 key 의 value 를 반환 , null 이면 defaultValue를 반환
			order.put(dish, order.getOrDefault(dish, 0) + quantity);
		}
	}

	// 2. 총 주문 가격을 계산하는 메서드
	public int calculateTotal() {
		int total = 0; // 총 가격 저장 변수

		// 주문된 모든 메뉴에 대해 반복
		for (String dish : order.keySet()) {
			// 주문서 - 요리 이름(키) & 수량(값)
			// 메뉴판 - 요리 이름(키) & 가격(값)
			total += order.get(dish) * menuPrices.get(dish);
		}
		return total;
	}

	// 3. 주문 완료 상태를 설정하는 메서드
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	// 4. 주문 완료 여부를 반환하는 메서드
	public boolean isComplete() {
		return isComplete;
	}

}
