package chapter03;

// 다차원 배열 
// : 배열의 배열 ( 2, 3, 4... 차원)
// >> 데이터를 테이블 형태로 구성할 때 유용
// >> 게임 보드. 데이터 분석, 그래픽 등에 사
public class B_Array {
	public static void main(String[] args) {
		// === 다차원 배열의 선언 및 초기화 ===
		// 2차원 배열 선언: 데이터타입[][] 배열명;
		int[][] matrix;

		// 2차원 배열 초기화: 배열명 = new 데이터타입[행수][열수];
		// 배열명 = new 데이터타입[반드시][선택]
		matrix = new int[3][3];

		// 각 요소에 값 할당
		matrix[0][0] = 1; // 1행1열
		matrix[0][1] = 2; // 1행2열
		matrix[0][2] = 3; // 1행3열

		matrix[1][2] = 4; // 2행3열

		// 선언과 동시에 초기화
		int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		// 다차원 배열 출력
		// >> 각 행을 순회하여, 해당 행 내부의 요소를 순
		for (int[] row : matrix2) { // 배열 
			for (int value : row) { // 변수 
				System.out.print(value + " ");
			}
			System.out.println(); // 줄바꿈
		}
	}
}
