package data_structure;

class Node_2_7{
	Node_2_7 next;
	Node_2_7 prev;
	Node_2_7 last;
	int data;
	
	public Node_2_7(int data, Node_2_7 next, Node_2_7 prev) {
		this.data = data;
		setNext(next);
		setPrevious(prev);
	}

	public Node_2_7(int data) {
		this.data = data;
	}

	public Node_2_7() {}

	public void setNext(Node_2_7 next) {
		this.next = next;
		if (this == last) last = next;
		if (next != null && next.prev != this) next.setPrevious(this);
	}
	
	public void setPrevious(Node_2_7 prev) {
		this.prev = prev;
		if (prev != null && prev.next != this) prev.setNext(this);
	}
	
	public Node_2_7 appendToTail(int data){
		Node_2_7 end = new Node_2_7(data);
		Node_2_7 n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
		end.prev = n;
		last = end;
		
		return end;
	}
}

public class Q_2_7 {
	
	public static boolean palindrome_check_1(Node_2_7 head){
		Node_2_7 tail = head.last;
		while(head!=null){
			if(head.data != tail.data) return false;
			head = head.next;
			tail = tail.prev;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node_2_7 head = new Node_2_7(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(1);
		
		System.out.println("회문 여부: "+palindrome_check_1(head));
	}
}
