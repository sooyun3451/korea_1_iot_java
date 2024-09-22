package chapter20.reservation.repository;

import java.util.ArrayList;
import java.util.List;

import chapter20.reservation.model.Reservation;

public class ReservationRepository {
	private List<Reservation> reservations; // 예약 목록

	public ReservationRepository() {
		this.reservations = new ArrayList<Reservation>();
	}

	// 예약 추가 메서드
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	// 예약 조회 메서드
	public Reservation findById(String reservationId) {
		for (Reservation reservation : reservations) {
			if (reservation.getReservationId().equals(reservationId)) {
				return reservation; // 예약 ID가 일치하는 예약반환
			}
		}
		return null; // 예약 없음
	}

	// 모든 예약 조회 메서드
	public List<Reservation> findAll() {
		return reservations;
	}
}
