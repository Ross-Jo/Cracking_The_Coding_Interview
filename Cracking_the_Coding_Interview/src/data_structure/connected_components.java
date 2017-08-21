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
			if(marked[v]==false){ // DFS를 이용하여 특정 노드에서 Connected component가 무엇인지 (해당 CC에 포함되어 있는 노드들을 색칠해가며) 알아낸다. 
				                  // 이와 같은 방식으로 Connected components들을 식별해 낸다.
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
	
	public int getCompSize(int v){return compsize[compid[v]];} // 해당 연결요소의 크기를 반환
	public int[] getCid() {return compid;} // 연결요소 ID를 반환함
	public int getCountCC() {return countCC;} // 연결요소의 갯수가 몇개나 되는지 파악
	public boolean isConnected(int v, int w){return compid[v]==compid[w];} // 두개의 노드가 연결되어 있는지 아닌지 판단
}

public class connected_components {
	
	public static void main(String[] args) {
		
	}

}
