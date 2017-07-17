package data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node_4_2{
	int nodeNum;
	boolean visited;
	public Node_4_2(int nodeNum){
		this.nodeNum = nodeNum;
		this.visited = false;
	}
}

public class Q_4_2 {
	// BFS로 루트 존재여부 탐색
	public static boolean findRoute(ArrayList<ArrayList<Node_4_2>> graph, int x, int y) {
		if (graph.get(x) == null) return false;

		Queue<Node_4_2> q = new LinkedList<Node_4_2>();
		graph.get(x).get(0).visited = true;
		System.out.println("탐색시작지점: " + graph.get(x).get(0).nodeNum);
		q.add(graph.get(x).get(0));

		Node_4_2 node = null;
		while (!q.isEmpty()) {
			node = q.poll();
			for (int i = 1; i < graph.get(node.nodeNum).size(); i++) {
				Node_4_2 n = graph.get(graph.get(node.nodeNum).get(i).nodeNum).get(0); // 이 부분이 너무 지저분 하다. 간략히 할 수 있는 방법을 연구할 것.
				if (n.visited == false) {
					if (n.nodeNum == y) {
						System.out.println("탐색종료지점: " + n.nodeNum);
						return true;
					}
					n.visited = true;
					q.add(n);
				}
			}
		}
		System.out.println("(탐색실패)탐색종료지점: " + node.nodeNum);
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Node_4_2>> graph = new ArrayList<ArrayList<Node_4_2>>();
		
		// 그래프 직접 입력 - 더 간단한 그래프 표현 방법에 대하여 고민해 볼 것
		int nodeNum = 9;
		int[][] matrix = new int[nodeNum][];
		matrix[0] = new int[]{1,3};
		matrix[1] = new int[]{2};
		matrix[2] = null;
		matrix[3] = new int[]{7};
		matrix[4] = new int[]{5,6};
		matrix[5] = null;
		matrix[6] = new int[]{7};
		matrix[7] = new int[]{8};
		matrix[8] = null;
		
		// ArrayList<ArrayList<Integer>>에 그래프 정보 입력
		for(int i=0; i<nodeNum; i++){
			graph.add(new ArrayList<Node_4_2>());
			graph.get(i).add(new Node_4_2(i));
			for(int j=0; matrix[i]!=null && j<matrix[i].length; j++){
				graph.get(i).add(new Node_4_2(matrix[i][j]));
			}
		}
		System.out.println("경로 존재 여부 : "+findRoute(graph, 0, 4));
	}
}