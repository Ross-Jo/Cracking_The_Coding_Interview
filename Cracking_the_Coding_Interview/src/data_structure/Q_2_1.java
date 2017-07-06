package data_structure;

/*
 * �ڵ��� ����. ��尡 ���� �� �ִ� �����Ͱ� ������ ����. �ߺ� üũ�� �ߺ� üũ�� ���� ������ �ӽ� �迭������ ũ�� �ۿ� �ȵ�
 * �ߺ� üũ�� ���� �ҿ� ���� ���⵵ O(1)
 * �ߺ� üũ�� ���� �ð� ���⵵ O(N)
 *  
 */

class Node { // Node Ŭ����
	Node next = null;
	int i;

	public Node(int i) {
		this.i = i;
	}

	void appendToTail(int i) {
		Node end = new Node(i);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_1 {

	public static void discard_duplication(Node startNode, Node head) {
		boolean[] check_m = new boolean[100]; // �ӽ� ����, 100ĭ
		Node tmp = head;

		while (startNode.next != null) {
			if (check_m[startNode.i]) {
				tmp.next = startNode.next; // ����������, ������ head
				startNode = startNode.next; // ����������, ������ head.next
				continue;
			}
			check_m[startNode.i] = true; // �ߺ� üũ�� ���� ǥ��
			tmp = startNode;
			startNode = startNode.next;
		}
		if (check_m[startNode.i]) { // ������ ��忡 ���� �ߺ� üũ�� ����
			tmp.next = startNode.next;
			startNode = startNode.next;
		}

	}

	public static void main(String[] args) {
		Node head = new Node(0); // 0 �� header ���

		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(7);

		discard_duplication(head.next, head);

		while (head.next != null) {
			System.out.print(head.next.i + " ");
			head.next = head.next.next;
		}
	}
}