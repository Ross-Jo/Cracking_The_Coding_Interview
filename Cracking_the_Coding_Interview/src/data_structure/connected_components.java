package data_structure;

class Node_CC{
	public Edge firstEdge;
	public int degree;
	public Node_CC(){
		firstEdge = null;
		degree = 0;
	}
}

class Edge{
	public int nodeNum;
	public Edge nextEdge;
	public Edge(int num, Edge e){
		nodeNum = num;
		nextEdge = e;
	}
}

class Graph{
	private int N; // number of nodes
	public Node_CC[] graph;
	
	public Graph(int n){
		N = n;
		graph = new Node_CC[N];
		for(int i=0; i<N; i++){
			graph[i] = new Node_CC();
		}
	}
	
	public void insertEdge(int tail, int head){
		graph[tail].firstEdge = new Edge(head, graph[tail].firstEdge);
		graph[tail].degree++;
	}
	
	public int V(){
		return N;
	}
	
	public int[] adj(int v){ // return node v's adjacent nodeNum as int array
		int count = 0;
		int[] adjNodes = new int[graph[v].degree];
		Edge p = graph[v].firstEdge;
		while(p!=null){
			adjNodes[count++] = p.nodeNum;
			p = p.nextEdge;
		}
		return adjNodes;
	}
	
}

class ConnectedComponent{ 
	private boolean[] marked;
	private int[] compid; // compid[v] = component ID of v
	private int[] compsize; // compsize[compid] = number of vertices in component
	private int countCC; // number of connected components
	
	public ConnectedComponent(Graph G){
		int n = G.V();
		marked = new boolean[n];
		compid = new int[n];
		compsize = new int[n];
		for(int v=0; v<n; v++){
			if(marked[v]==false){ // DFS�� �̿��Ͽ� Ư�� ��忡�� Connected component�� �������� (�ش� CC�� ���ԵǾ� �ִ� ������ ��ĥ�ذ���) �˾Ƴ���. 
				                  // �̿� ���� ������� Connected components���� �ĺ��� ����.
				dfs(G, v);
				countCC++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		compid[v] = countCC;
		compsize[countCC]++;
		for(int i: G.adj(v)){
			if(!marked[i]){
				dfs(G,i);
			}
		}
	}
	
	public int getCompSize(int v){return compsize[compid[v]];} // �ش� �������� ũ�⸦ ��ȯ
	public int[] getCid() {return compid;} // ������ ID�� ��ȯ��
	public int getCountCC() {return countCC;} // �������� ������ ��� �Ǵ��� �ľ�
	public boolean isConnected(int v, int w){return compid[v]==compid[w];} // �ΰ��� ��尡 ����Ǿ� �ִ��� �ƴ��� �Ǵ�
}

public class connected_components {
	
	public static void main(String[] args) {
		
	}

}
