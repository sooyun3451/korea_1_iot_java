package chapter20.reservation.model;

/*
	Reservation 클래스(model)
	- 예약 정보를 담는 클래스 
	- 속성: 예약 ID, 사용자 ID, 예약 시간, 예약 상태 등 
*/
public class Reservation {
	private String reservationId;
	private String userId;
	private String reservationTime;
	private boolean isActive;

	public Reservation(String reservationId, String userId, String reservationTime) {
		this.reservationId = reservationId;
		this.userId = userId;
		this.reservationTime = reservationTime;
		this.isActive = true; // 기본값으로 예약은 활성 상태로 생성
	}

	// Getter
	public String getReservationId() {
		return reservationId;
	}

	public String getUserId() {
		return userId;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public boolean isActice() {
		return isActive;
	}

	// Setter
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public void cancle() {
		this.isActive = false; // 예약을 취소하면 비활성 상태로 변경
	}

}
