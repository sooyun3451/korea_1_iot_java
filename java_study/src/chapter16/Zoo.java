package chapter16;

import chapter16.Zoo.Lion;

// 동물들의 행동을 졍의할 Animal 인터페이스 정의 
interface Animal {
	void performAction(); // 동물의 행동을 정의하는 추상 메서드
}

// 동물원 관리 시스템을 구현 
class Zoo {

	// 사자 클래스
	// 인터페이스 Animal을 구현(implements)하는 사자 클래스
	static class Lion implements Animal {
		private String day; // 요일에 따라 사자의 행동이 달라집

		// 생성자에서 요일을 받음
		public Lion(String day) {
			this.day = day;
		}

		@Override
		public void performAction() {
			// a.equalsIgnoreCase(b)
			// : 대소문자 구분 없이 문자열 비교
			if (day.equalsIgnoreCase("Sunday")) {
				// 일요일 - 사냥
				class SundayAction implements Animal {

					@Override
					public void performAction() {
						System.out.println("사자는 사냥합니다.");
					}
				}

				// 내부 클래스 객체 생성 후 행동 수행
				Animal specialAction = new SundayAction();
				specialAction.performAction();

			} else {
				// 람다표현식을 사용하여 평소 행동을 정의
				Animal regularAction = () -> System.out.println("사자가 포효합니다.");
				regularAction.performAction();
			}

		}
	}
	
	// 원숭이 클래스
	static class Monkey implements Animal {
		@Override
		public void performAction() {
			Animal action = () -> System.out.println("원숭이는 나무를 타고 오릅니다.");
			action.performAction();
		}
	}
	
	public static void main(String[] args) {
		Animal lion = new Lion("Sunday");
		lion.performAction(); // 사자는 사냥합니다.
		
		Animal lion2 = new Lion("Monday");
		lion2.performAction(); // 사자가 포효합니다.
		
		Animal monkey = new Monkey();
		monkey.performAction(); // 원숭이는 나무를 타고 오릅니다.
		
		Animal penguin = new Animal() {
			// 익명클래스 - 팽귄의 행동 정의 
			@Override
			public void performAction() {
				// 익명클래스 내부에서 펭귄의 행동 정의 
				System.out.println("귄은 뒤뚱뒤뚱 걷습니다.");
			}
		};
		penguin.performAction(); // 귄은 뒤뚱뒤뚱 걷습니다.
	}

}