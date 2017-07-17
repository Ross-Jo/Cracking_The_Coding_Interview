package data_structure;

import java.util.Queue;

class Node{}

public class tree_and_graph {
	
	//sudo
	/*
	public static void DFS(Node root){
		if(root==null) return;
		
		visit(root);
		root.visited = true;
		
		foreach(Node n in root.adjacent){
			if(n.visited == false)
				DFS(n);
		}
	}
	*/
	
	//sudo - Queue 활용이 키 포인트
	/*
	public static void BFS(Node root){
		Queue queue = new Queue();
		
		root.visited = true;
		visit(root);
		queue.enqueue(root);
		
		while(!queue.isEmpty()){
			Node r = queue.dequeue();
			foreach(Node n in r.adjacent){
				if(n.visited == false){
					visit(n);
					n.visited = true;
					queue.enqueue(n);
				}
			}
		}
	}
	*/
	
	public static void main(String[] args) {

	}

}
