package data_structure;

// �ð� ���⵵
// ���� ��� ���� : O(N^?)
// ���� ����Ʈ ���� : O(NE)
// �������� : No negative cycle
public class bellman_ford {
	
	/*
	public void bellman_ford(s){
		for(i=0; i<n; i++) dist[i] = adj[s][i]; // k=1
		
		perform the following n-1 times;
			for(each node u (u!=s) with at least one incoming edge)
				for (each <i, u> in the graph)
					if (dist[u] > dist[i]+adj[i][u]){ // edge relaxation
						dist[u] + dist[i]+adj[i][u];
						prev[u] = i; // ��� ������ ���� �ʿ�
					}
	}
	
	BELLMAN-FORD(G, w, s)
		INITIALIZE-SINGLE-SOURCE(G,s)
		for i = 1 to |G.V|-1
			for �� ���� (u, v) in G.E
				RELAX(u, v, w)
		for �� ���� (u, v) in G.E
			if v.d > u.d + w(u,v)
				return FALSE
		return TRUE
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
