package data_structure;

// �ð� ���⵵ : O(n^3)
// �������� : No cycle whose cost is < 0
public class floyd_warshall {
	/*
	public static void AllPairShortestPaths(){
		 procedure floyd-warshall(�� ������ �մ� �𼭸��� ����ġ ���̺� W)
		     D : �� ������ �մ� ����� �ּ� ��� ���̺�. ��� ������ �ķ� �ʱ�ȭ
		     M : �� ������ �������� �ּ� ��� ��ΰ� ���ľ� �� ������ ������ ���̺�. ��� ������ null�� �ʱ�ȭ
		     for i from 1 to |V|
		         for j from 1 to |V|
		             D[i][j] := W[i][j]
		     for v from 1 to |V|
		         D[v][v] := 0
		     for k from 1 to |V|
		        for i from 1 to |V|
		            for j from 1 to |V|
		                if D[i][j] > D[i][k] + D[k][j]
		                    D[i][j] := D[i][k] + D[k][j]
		                    M[i][j] := k
		    return D
				
		 procedure floyd-warshall-path(���� v1, ���� v2, ������ ���̺� M)
		      S : ��θ� ������ �����ϴ� ����
		      P : ���
		      S.push(v2)
		      while M[v1][S.top()]
		    		  S.push(M[v1][S.top()])
		      while ~S.empty()
		    		  P.add(S.top())
		    		  S.pop()
		      return P
	}
	
	int d[N][N]; // Cost Table. d[v1][v2] : Minimum cost of path v1 -> v2
	int via[N][N]; // Via Table.
	int weight[N][N]; // Weight

	void doFloyd() {
		// Initialize
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				d[i][j] = weight[i][j]; // k = 0
			}
		}

		// Do Floyd-Warshall Algorithm
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						via[i][j] = k;
					}
				}
			}
		}
	}
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
