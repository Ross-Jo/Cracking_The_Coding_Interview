package data_structure;

/*
 * 본인은 노드가 일부 추가적인 정보를 가지고 있다고 생각, 문제 풀이에 접근함 (하지만 solution을 참고하니 원래 문제의 취지는 이게 아닌 듯 하다)
 * boolean touch : 포인터가 해당 노드를 건드렸는지 혹은 그렇지 않은지를 기록
 * 
 */
class Node_2_6{
	Node_2_6 next;
	Node_2_6 prev;
	Node_2_6 last;
	int data;
	boolean touch;
	
	public Node_2_6(int data, Node_2_6 next, Node_2_6 prev) {
		this.data = data;
		setNext(next);
		setPrevious(prev);
	}

	public Node_2_6(int data) {
		this.data = data;
		this.touch = false;
	}

	public Node_2_6() {}

	public void setNext(Node_2_6 next) {
		this.next = next;
		if (this == last) last = next;
		if (next != null && next.prev != this) next.setPrevious(this);
	}
	
	public void setPrevious(Node_2_6 prev) {
		this.prev = prev;
		if (prev != null && prev.next != this) prev.setNext(this);
	}
	
	public Node_2_6 appendToTail(int data){
		Node_2_6 end = new Node_2_6(data);
		Node_2_6 n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
		end.prev = n;
		last = end;
		return end;
	}
}

public class Q_2_6 {
	
	public static Node_2_6 cp_search(Node_2_6 head){
		Node_2_6 sp = head;
		while(head!=null){
			if(head.touch == true) return head;
			head.touch = true;
			head = head.next;
		}
		System.out.println("순환되는 부분이 없음(이 경우 시작부분을 반환함)");
		return sp;
	}
	
	public static void main(String[] args) {
		Node_2_6 head = new Node_2_6(1);
		head.appendToTail(2);
		Node_2_6 target1 = head.appendToTail(3);
		head.appendToTail(4);
		Node_2_6 target2 = head.appendToTail(5);
		target2.next = target1;
		
		System.out.println("순환되는 부분의 첫 노드: "+cp_search(head).data);
	}
}
