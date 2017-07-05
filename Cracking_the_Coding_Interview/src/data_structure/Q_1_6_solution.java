package data_structure;

/* 
 * 입력 행렬의 모양은 정방형
 * layer별로 회전 작업을 진행
 * O(n^2)의 시간 복잡도를 가짐 : N^2개의 모든 원소를 다 건드려야 하기 때문
 * 
 */

public class Q_1_6_solution {
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) { // 반복문에서 ++i나 i++가 엄청난 차이가 있지는 않음
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = { { 10, 11, 12, 13 }, { 14, 15, 16, 17 }, { 18, 19, 20, 21 }, { 22, 23, 24, 25 } };
		int N = 4;
		rotate(input, N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}