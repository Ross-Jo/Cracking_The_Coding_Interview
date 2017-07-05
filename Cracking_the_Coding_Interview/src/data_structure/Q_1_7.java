package data_structure;

import java.util.Set;
import java.util.HashSet;

public class Q_1_7 {
	public static void modify_array(int[][] matrix, int M, int N) {
		Set<Integer> row = new HashSet<Integer>(); // set 사용법 봐두기
		Set<Integer> col = new HashSet<Integer>();

		int[][] tmp = new int[matrix.length][matrix[0].length]; // 원본 배열을 저장해두기
																// 위한 배열
		for (int i = 0; i < matrix.length; i++) {
			System.arraycopy(matrix[i], 0, tmp[i], 0, matrix[0].length);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] == 0) {
					if (!row.contains(i)) { // 중복 처리를 막기 위한 체크
						for (int x = 0; x < N; x++) {
							matrix[i][x] = 0;
						}
					}
					if (!col.contains(j)) {
						for (int y = 0; y < M; y++) {
							matrix[y][j] = 0;
						}
					}
					row.add(M);
					col.add(N);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = { { 10, 11, 12 }, 
				          { 14, 15, 16 }, 
				          { 18, 19, 0 }, 
				          { 21, 22, 23 }, 
				          { 24, 25, 26 } };
		int M = 5;
		int N = 3;
		modify_array(input, M, N);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

}