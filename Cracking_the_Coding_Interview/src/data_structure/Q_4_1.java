package data_structure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node_4_1{
	int hight;
	int name;
	boolean visited;
	Node_4_1 parent;
	Node_4_1 leftChildren;
	Node_4_1 RightChildren;
	
	public Node_4_1 (int name, Node_4_1 parent, int hight){
		this.name = name;
		this.parent = parent;
		this.hight = hight;
	}
}

public class Q_4_1 {
	
	static Set<Integer> s = new HashSet<Integer>();
	
	public static Node_4_1 treeCreate(Node_4_1 root, int num){
		Queue<Node_4_1> q = new LinkedList<Node_4_1>();
		int check = 1;
		int name = root.name;
		q.add(root);
		
		while(!q.isEmpty()){
			Node_4_1 t = q.poll();
			if(check!=num){
				Node_4_1 lc = new Node_4_1(++name, t, t.hight+1); check++;
				t.leftChildren = lc;
				System.out.println("t.name: "+t.name+" ");
				System.out.println("lc.name: "+lc.name+" ");
				q.add(lc);
			}
			if(check!=num){
				Node_4_1 rc = new Node_4_1(++name, t, t.hight+1); check++;
				t.RightChildren = rc;
				System.out.println("t.name: "+t.name+" ");
				System.out.println("rc.name: "+rc.name+" ");
				q.add(rc);
			}
		}
		return root;
	}
	
	public static void BBTsearch(Node_4_1 root){
		if(root==null) return;
		visit(root);
		root.visited = true;
		if(root.leftChildren != null && root.visited == false) BBTsearch(root.leftChildren);
		if(root.RightChildren != null && root.visited == false) BBTsearch(root.RightChildren);
	}
	
	public static <T> boolean BBTsearch(){
		if(s.size()>=3) return false;
		else return true;
	}
	
	public static <T> void visit(Node_4_1 root){
		if(root.leftChildren == null && root.RightChildren == null){
			s.add((Integer) root.hight);
		}
	}
	
	public static void main(String[] args) {
		Node_4_1 root = new Node_4_1(1,null,1);
		root = treeCreate(root, 10); // 음...애당초 트리를 균형 이진 트리로 생성하는데@@
		BBTsearch(root);
		System.out.println("균형 이진 트리 여부: "+BBTsearch());
	}
}
