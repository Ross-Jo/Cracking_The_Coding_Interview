package data_structure;

/* 
 * �Է� ����� ����� ������
 * layer���� ȸ�� �۾��� ����
 * O(n^2)�� �ð� ���⵵�� ���� : N^2���� ��� ���Ҹ� �� �ǵ���� �ϱ� ����
 * 
 */

public class Q_1_6_solution {
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) { // �ݺ������� ++i�� i++�� ��û�� ���̰� ������ ����
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