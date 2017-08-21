package data_structure;

// 간선이 음수의 cost를 가지는 경우는 사용 불가
// 시작 vertex로 부터 다른 모든 vertex들 까지의 가장 짧은 거리를 찾아냄
// 시간 복잡도는 O(n^2). cf. 바이너리 힙 사용의 경우 : O(elogN), 피보나치 힙 사용의 경우 O(NlogN+e)
// input이 dense 한 경우 좋음
public class dijkstra {

	/*
	public void SortestPath(s){ // s is the start vertex
		for(i=0; i<n ; i++){visited[i]=false, dist[i]=adj[s][i]} // 만약 직접적인 edge가 없는 경우에는 무한대로 채워줌
		
		visited[s] = true; dist[s] = 0;
		
		for(int i=0; i<n-1; i++){
		int min = findMin(); // find u with a smallest dist(u)=min w {dist[w]} where visited[w] = false
		                     // 즉 아직 방문하지 않은 노드들의 dist값들 중 min을 찾음
		
		visited[min] = true; // 트리(방문한 노드들을 트리...라고 가정한다면)에 해당 노드를 포함
		
			for(w=0; w<n; w++){ // perform edge relaxation
				if(!visited[w] && (dist[min]+adj[min][w] < dist[w])){
					dist[w] = dist[min] + adj[min][w];
					prev[w] = min; // 경로 추적을 위한 코드. edge relaxation을 시켜준 노드가 이전 노드가 된다.
				}
			}
		}
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
