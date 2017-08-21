package data_structure;

// 시간 복잡도 : O(n^3)
// 제약조건 : No cycle whose cost is < 0
public class floyd_warshall {
	/*
	public static void AllPairShortestPaths(){
		 procedure floyd-warshall(두 정점을 잇는 모서리의 가중치 테이블 W)
		     D : 두 정점을 잇는 경로의 최소 비용 테이블. 모든 성분을 ∞로 초기화
		     M : 두 정점을 지나가는 최소 비용 경로가 거쳐야 할 마지막 경유지 테이블. 모든 성분을 null로 초기화
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
				
		 procedure floyd-warshall-path(정점 v1, 정점 v2, 경유지 테이블 M)
		      S : 경로를 역으로 저장하는 스택
		      P : 경로
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
