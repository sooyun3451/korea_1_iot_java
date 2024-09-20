package chapter20.reservation.service;

import java.util.ArrayList;
import java.util.List;

import chapter20.reservation.model.Reservation;

/*
	ReservationService 클래스(service)
	- 예약 생성, 확인, 취소 관련 기능 구현 
	- 메서드 정의 
*/
public class ReservationService {
	private List<Reservation> reservations;
	
	public ReservationService() {
		this.reservations = new ArrayList<Reservation>();
	}
	
	// 예약 생성 메서드 
	public void createReservation(String reservationId, String userId, String reservationTime) {
		Reservation newreservation = new Reservation(reservationId, userId, reservationTime);
		reservations.add(newreservation); // 예약 목록에 추가 
		System.out.println("예약 완료: " + reservationTime);
	}
	
	// 예약 확인 메서드 
	public List<Reservation> getReservations(String userId) {
		List<Reservation> userReservations = new ArrayList<Reservation>();
		for(Reservation reservation: reservations) {
			if(reservation.getUserId().equals(userId) && reservation.isActice()) {
				userReservations.add(reservation); // 활성 예약 추가 
			}
		}
		return userReservations; // 사용자의 활성 예약 목록 반환 
	}
	
	// 예약 취소메서드 
	public void cancelReservation(String reservationId) {
		for(Reservation reservation: reservations) {
			if(reservation.getReservationId().equals(reservationId) && reservation.isActice()) {
				reservation.cancle(); // 예약 취소 
				System.out.println("예약 취소 완료" + reservationId);
				return;
			}
		}
		System.out.println("예약 취소 실패: 예약 ID가 잘못되었습니다.");
	}
	

}
