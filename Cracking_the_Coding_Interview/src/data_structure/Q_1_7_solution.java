package data_structure;

public class Q_1_7_solution {

	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String args[]) {
		int[][] input = { { 10, 11, 12 }, 
				          { 14, 15, 16 }, 
				          { 18, 19, 0 }, 
				          { 21, 22, 23 }, 
				          { 24, 25, 26 } };
		int M = 5;
		int N = 3;
		setZeros(input);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}
