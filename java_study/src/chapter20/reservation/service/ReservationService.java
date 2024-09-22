package chapter20.reservation.service;

import java.util.List;

import chapter20.reservation.model.Reservation;
import chapter20.reservation.repository.ReservationRepository;

/*
	ReservationService 클래스(service)
	- 예약 생성, 확인, 취소 관련 기능 구현 
	- 메서드 정의 
*/
public class ReservationService {
	private ReservationRepository reservationRepository; // 예약 저장소

	public ReservationService() {
		// 예약 저장소 초기화
		this.reservationRepository = new ReservationRepository();
	}

	// 예약 생성 메서드
	public void createReservation(String reservationId, String userId, String reservationTime) {
		Reservation newreservation = new Reservation(reservationId, userId, reservationTime);
		reservationRepository.addReservation(newreservation); // 예약 목록에 추가
		System.out.println("예약 완료: " + reservationTime);
	}

	// 예약 확인 메서드
	public List<Reservation> getReservations(String userId) {
		List<Reservation> userReservations = reservationRepository.findAll();
		return userReservations.stream()
				.filter(reservation -> reservation.getUserId().equals(userId) && reservation.isActice()).toList(); // 사용자ID와 활성 예약 필터
	}

	// 예약 취소메서드
	public void cancelReservation(String reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId);
		if (reservation != null && reservation.isActice()) {
			reservation.cancle(); // 예약 취소
			System.out.println("예약 취소 완료" + reservationId);
		} else {
			System.out.println("예약 취소 실패: 예약 ID가 잘못되었습니다.");
		}
	}
}
