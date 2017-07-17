package data_structure;

import java.util.LinkedList;

class Graph_4_2_solution {
	public static int MAX_VERTICES = 6;
	private Node_4_2_solution vertices[];
	public int count;
	public Graph_4_2_solution() {
		vertices = new Node_4_2_solution[MAX_VERTICES];
		count = 0;
    }
	
    public void addNode(Node_4_2_solution x) {
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node_4_2_solution[] getNodes() {
        return vertices;
    }
}

class Node_4_2_solution {
    private Node_4_2_solution adjacent[];
    public int adjacentCount;
    private String vertex;
    public Q_4_2_solution.State state;
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
    public Node_4_2_solution[] getAdjacent() {
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

	public static void main(String a[])
	{
		Graph_4_2_solution g = createNewGraph();
		Node_4_2_solution[] n = g.getNodes();
		Node_4_2_solution start = n[3];
		Node_4_2_solution end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph_4_2_solution createNewGraph()
	{
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
        for (Node_4_2_solution u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node_4_2_solution u;
        while(!q.isEmpty()) {
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
            }
        }
        return false;
    }
}
