package data_structure;

class Node_2_2 {
	Node_2_2 next;
	int data;

	public Node_2_2(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		Node_2_2 end = new Node_2_2(data);
		Node_2_2 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_2 {

	public static Node_2_2 find_specific_node(Node_2_2 n, int k) {
		int total = 0;
		Node_2_2 result = n;
		while (n != null) {
			++total;
			n = n.next;
		}
				
		for (int i = 0; i < total - k; i++) { // k>total인 경우 for문에서 처리. (즉, 가장 첫번쨰 원소만 나오게 됨)
			result = result.next;
		}
		return result;
	}

	public static void main(String[] args) {
		
		Node_2_2 head = new Node_2_2(0);
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(7);

		System.out.println(find_specific_node(head, 1).data);		
	}
}