package data_structure;

import java.util.Hashtable;

class LinkedListNode { // Node 클래스
	LinkedListNode next = null;
	int data;

	public LinkedListNode(int data) {
		this.data = data;
	}

	void appendToTail(int data) {
		LinkedListNode end = new LinkedListNode(data);
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_1_solution {

	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable(); // Hashtable을 사용해서 자료형 타입 제약 및 연결되는 duplication check를 위한 node갯수 제약을 없앰
		LinkedListNode previous = null;
		while (n != null) { // 여기 주목해서 볼 것
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}

	public static void main(String args[]) {
		LinkedListNode head = new LinkedListNode(0);

		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(7);

		deleteDups(head);

		while (head != null) { // 여기도 이런 식으로 출력하면 되는 것을 주목
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
