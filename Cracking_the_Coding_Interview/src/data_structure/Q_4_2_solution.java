package data_structure;

import java.util.LinkedList;

// 문제에 따라 본인이 적절한 자료구조를 만들 줄 알아야 한다.
class Graph_4_2_solution {
	public static int MAX_VERTICES = 6; 
	private Node_4_2_solution vertices[]; // 그래프가 가지고 있는 노드 모음, 노드의 1차원 배열
	public int count; // 그래프 노드 추가시 추가된 노드 카운트

	public Graph_4_2_solution() {
		vertices = new Node_4_2_solution[MAX_VERTICES];
		count = 0;
	}

	public void addNode(Node_4_2_solution x) { // bucket을 전체적으로 생성하고, 내용물을 채워가는 방식
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
	}

	public Node_4_2_solution[] getNodes() { // 그래프가 가지고 있는 노드 배열 반환
		return vertices;
	}
}

class Node_4_2_solution { 
	private Node_4_2_solution adjacent[]; // 인접 노드를 노드 행렬로 저장함, 노드 자체가 인접 노드에 대한 정보를 가지고 있음
	public int adjacentCount; // 인접 노드 삽입 시, 갯수 카운트
	private String vertex; // 노드의 이름
	public Q_4_2_solution.State state; // enum을 정의한 클래스의 enum활용 / 정의한 enum 타입, BFS 탐색 시 노드의 상태를 나타냄

	public Node_4_2_solution(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new Node_4_2_solution[adjacentLength];
	}

	public void addAdjacent(Node_4_2_solution x) {
		if (adjacentCount < adjacent.length) {
			this.adjacent[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.print("No more adjacent can be added");
		}
	}

	public Node_4_2_solution[] getAdjacent() { // 귀찮아서 계속 getter, setter 안쓰는 경우 있는데 유의하기
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}
}

public class Q_4_2_solution {
	public enum State {
		Unvisited, Visited, Visiting;
	}

	public static void main(String a[]) {
		Graph_4_2_solution g = createNewGraph();
		Node_4_2_solution[] n = g.getNodes();
		Node_4_2_solution start = n[3];
		Node_4_2_solution end = n[5];
		System.out.println(search(g, start, end));
	}

	public static Graph_4_2_solution createNewGraph() {
		// 그래프 생성과정 내 표현과 어떻게 다른지 비교하기
		Graph_4_2_solution g = new Graph_4_2_solution();
		Node_4_2_solution[] temp = new Node_4_2_solution[6];

		temp[0] = new Node_4_2_solution("a", 3);
		temp[1] = new Node_4_2_solution("b", 0);
		temp[2] = new Node_4_2_solution("c", 0);
		temp[3] = new Node_4_2_solution("d", 1);
		temp[4] = new Node_4_2_solution("e", 1);
		temp[5] = new Node_4_2_solution("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static boolean search(Graph_4_2_solution g, Node_4_2_solution start, Node_4_2_solution end) {
		LinkedList<Node_4_2_solution> q = new LinkedList<Node_4_2_solution>();
		for (Node_4_2_solution u : g.getNodes()) u.state = State.Unvisited;
		
		start.state = State.Visiting;
		q.add(start);
		
		// 자료구조를 적절하게 활용한 결과 내가 작성했던 코드보다 훨씬 가독성이 좋음
		Node_4_2_solution u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for (Node_4_2_solution v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			} // 3개의 상태를 사용할 필요는 없는데 굳이 3개의 상태를 사용한 이유를 고민해 볼 것
		}
		return false;
	}
}