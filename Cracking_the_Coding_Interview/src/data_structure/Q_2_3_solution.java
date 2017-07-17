package data_structure;

class LinkedListNode_2_3 {
	LinkedListNode_2_3 next = null;
	int data;

	public LinkedListNode_2_3(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		LinkedListNode_2_3 end = new LinkedListNode_2_3(data);
		LinkedListNode_2_3 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}


/*
 * 이 문제의 경우 문제의 가이드라인이 명확하지 않아 해석이 갈릴 수 있기에 만약 이와 비슷한 문제가 출제 된다면 출제자와의
 * 커뮤니케이션을 통해 확실한 가이드라인을 받아 둘 필요가 있음.
 * 
 */

public class Q_2_3_solution {

	public static boolean deleteNode(LinkedListNode_2_3 n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		LinkedListNode_2_3 next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode_2_3 head = new LinkedListNode_2_3(0); // 0 은 header 취급
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);

		deleteNode(head.next.next); // 가운데에 있는 원소

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}