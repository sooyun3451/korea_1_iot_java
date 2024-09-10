package chapter11;

import java.util.ArrayList;
import java.util.LinkedList;

// ArrayList / LinkedList 
// >> 요소 추가,삭제: 중간에 추가,삭제 시 속도 차이O, 끝에 추가 시에는 ArrayList가 더 나음.

// 이벤트 관리 시스템

// 이벤트 참가자 명단 관리 
// : 사전에 등록, 이벤트 당일에는 추가적인 참가자 등록 X
// >> ArrayList (목록 추가,삭제X / 참가자 조회O)

// 대기열 관리 
// : 이벤트에는 한정된 좌석, 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록 
// >> 위의 이벤트 참가자들이 퇴장하는 경우 입장 가능 
// >> LinkedList(목록 추가,삭제O / 참가자 조회X)

class EventManagement {
	// 이벤트 참여자 명단
	ArrayList<String> participantList = new ArrayList<>();

	// 대기열 명단
	LinkedList<String> waitingQueue = new LinkedList<>();

	// 1. 참가자 명단에 참가자 추가
	void addParticipant(String name) {
		participantList.add(name);
	}

	// 2. 대기열에 참가자 추가
	void addToWaitingQueue(String name) {
		waitingQueue.add(name);
	}

	// 3. 참가자가 이벤트를 떠날 때
	// >> 대기열의 인원을 추가
	void leaveParticipant(String name) {
		// 대기열 요소의 수가 0보다 클때(명단이 존재할 때)
		if (waitingQueue.size() > 0) {
			String nextParticipant = waitingQueue.remove(0);
			addParticipant(nextParticipant);
		}
	}
	
	// 4. 특정 참가자 조회 
	boolean checkParticipant(String name) {
		return participantList.contains(name);
	}

}

public class C_ListPractice {
	public static void main(String[] args) {
		EventManagement event = new EventManagement();
		
		// 참가자 명단에 참가자 추가 
		event.addParticipant("홍길동");
		event.addParticipant("홍길서");
		event.addParticipant("홍길남");
		event.addParticipant("홍길북");
		
		// 대기열에 참가자 추가 
		event.addToWaitingQueue("윤대휘");
		event.addToWaitingQueue("김소빈");
		event.addToWaitingQueue("정규민");
		
		System.out.println(event.participantList); // [홍길동, 홍길서, 홍길남, 홍길북]
		System.out.println(event.waitingQueue); // [윤대휘, 김소빈, 정규민]
		// 참가자가 이벤트를 떠날때 
		event.leaveParticipant("홍길동");
		
		System.out.println(event.participantList); // [홍길동, 홍길서, 홍길남, 홍길북, 윤대휘]
		
		event.leaveParticipant("홍길남");
		System.out.println(event.participantList); // [홍길동, 홍길서, 홍길남, 홍길북, 윤대휘, 김소빈]
		
		
		System.out.println(event.checkParticipant("홍길동")); // true
		System.out.println(event.checkParticipant("홍길남")); // true
		System.out.println(event.checkParticipant("정규민")); // false
	}

}
