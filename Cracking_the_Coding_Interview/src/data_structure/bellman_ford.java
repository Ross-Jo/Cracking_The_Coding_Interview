package data_structure;

// 시간 복잡도
// 인접 행렬 사용시 : O(N^?)
// 인접 리스트 사용시 : O(NE)
// 제약조건 : No negative cycle
public class bellman_ford {
	
	/*
	public void bellman_ford(s){
		for(i=0; i<n; i++) dist[i] = adj[s][i]; // k=1
		
		perform the following n-1 times;
			for(each node u (u!=s) with at least one incoming edge)
				for (each <i, u> in the graph)
					if (dist[u] > dist[i]+adj[i][u]){ // edge relaxation
						dist[u] + dist[i]+adj[i][u];
						prev[u] = i; // 경로 추적을 위해 필요
					}
	}
	
	BELLMAN-FORD(G, w, s)
		INITIALIZE-SINGLE-SOURCE(G,s)
		for i = 1 to |G.V|-1
			for 각 간선 (u, v) in G.E
				RELAX(u, v, w)
		for 각 간선 (u, v) in G.E
			if v.d > u.d + w(u,v)
				return FALSE
		return TRUE
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
