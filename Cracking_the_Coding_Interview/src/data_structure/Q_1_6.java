package data_structure;

/*
 * 입력 행렬의 모양은 정방형
 * 여기서는 행렬을 하나 더 사용함. -> 고쳐야 할 점
 */

public class Q_1_6 {
	public static int[][] rotate_90(int[][] m, int N) {
		int[][] r = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				r[j][N - 1 - i] = m[i][j];
			}
		}
		return r;
	}

	public static void main(String[] args) {
		int[][] input = { { 10, 11, 12, 13 }, { 14, 15, 16, 17 }, { 18, 19, 20, 21 }, { 22, 23, 24, 25 } };
		int N = 4;
		input = rotate_90(input, N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}