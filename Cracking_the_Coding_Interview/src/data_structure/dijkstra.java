package data_structure;

// ������ ������ cost�� ������ ���� ��� �Ұ�
// ���� vertex�� ���� �ٸ� ��� vertex�� ������ ���� ª�� �Ÿ��� ã�Ƴ�
// �ð� ���⵵�� O(n^2). cf. ���̳ʸ� �� ����� ��� : O(elogN), �Ǻ���ġ �� ����� ��� O(NlogN+e)
// input�� dense �� ��� ����
public class dijkstra {

	/*
	public void SortestPath(s){ // s is the start vertex
		for(i=0; i<n ; i++){visited[i]=false, dist[i]=adj[s][i]} // ���� �������� edge�� ���� ��쿡�� ���Ѵ�� ä����
		
		visited[s] = true; dist[s] = 0;
		
		for(int i=0; i<n-1; i++){
		int min = findMin(); // find u with a smallest dist(u)=min w {dist[w]} where visited[w] = false
		                     // �� ���� �湮���� ���� ������ dist���� �� min�� ã��
		
		visited[min] = true; // Ʈ��(�湮�� ������ Ʈ��...��� �����Ѵٸ�)�� �ش� ��带 ����
		
			for(w=0; w<n; w++){ // perform edge relaxation
				if(!visited[w] && (dist[min]+adj[min][w] < dist[w])){
					dist[w] = dist[min] + adj[min][w];
					prev[w] = min; // ��� ������ ���� �ڵ�. edge relaxation�� ������ ��尡 ���� ��尡 �ȴ�.
				}
			}
		}
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
