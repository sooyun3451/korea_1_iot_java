package chapter08;

//	=== 다형성 ===
//	Animal, Cat, Dog 클래스 선언

//	Animal 클래스: sound 메서드 (The animal makes a sound)

//	Cat, Dog 클래스 - Animal 클래스를 상속
//	: sound 메서드를 오버라이딩 >> 각각 "meow", "bark" 출력

class Animal {
	void sound() {
		System.out.println("The animal makes a sound");
	}
}

class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("meow");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("bark");
	}
}

//	=== instanceof 연산자 === 
//	AnimalChecker 클래스 선언
//	: Animal, Cat, Dog 클래스를 사용하여 다형성을 확인하는 메서드 작성
//	: checkAnimalType 메서드 - Animal 타입의 매개변수를 전달
//	: instanceof 연산자를 사용하여 매개변수가 Cat과 Dog 중 어느 인스턴스인지 확인
//	: Cat > 'cat'출력 / Dog > 'dog'출력 / 둘 다 X > 'Unknown animal type'

class AnimalChecker {
	void checkAniamlType(Animal animal) {
		if (animal instanceof Dog) {
			System.out.println("dog");
		} else if (animal instanceof Cat) {
			System.out.println("cat");
		} else {
			System.out.println("Unkown animal type");
		}
	}
}

public class C_Practice {
	public static void main(String[] args) {
		
		// Animal, Cat, Dog 클래스의 객체를 Animal타입으로 저장 
		AnimalChecker animalChecker = new AnimalChecker();
		
		Animal myPet1 = new Animal();
		animalChecker.checkAniamlType(myPet1); // Unkown animal type
		
		// 강제 형변환의 경우 
		// >> 자동 형 변환으로 본인의 상속받은 클래스 형태를 다시 인스턴스의 타입으로 변환할 경우에 사용 
		// Dog myPetDog = (Dog) myPey1;
		// animalChecker.checkAniamlType(myPetDog); - Error
		
		Animal myPet2 = new Dog();
		animalChecker.checkAniamlType(myPet2); // dog
		
		Animal myPet3 = new Cat();
		animalChecker.checkAniamlType(myPet3); // cat

		Cat cat = new Cat();
		cat.sound(); // meow

		Dog dog = new Dog();
		dog.sound(); // bark

	}

}
