package data_structure;

class LinkedListNode_2_2 { // Node Ŭ����
	LinkedListNode_2_2 next = null;
	int data;

	public LinkedListNode_2_2(int data) {
		this.data = data;
	}

	void appendToTail(int data) {
		LinkedListNode_2_2 end = new LinkedListNode_2_2(data);
		LinkedListNode_2_2 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

class IntWrapper { // WrapperŬ������ �̿��� ������ ���� �� ������ �䳻��
	public int value = 0;
}

public class Q_2_2_solution {
	/*
	 * ��͸� ���� �ܹ��� linked list������ �ڿ��� ���� k��° ��Ҹ� ã�� �ٸ� ���⼭�� ���Ҹ� ��ȯ���� �ʰ� ī���� ����
	 * ��ȯ��
	 */
	public static int nthToLast(LinkedListNode_2_2 head, int k) {
		if (head == null) {
			return 0;
		}
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return i;
	}

	/*
	 * ���� ��͸� ���� ����ε� wrapperŬ������ Ȱ���Ͽ� ī���� �� �� ��ü�� ��ȯ�� head �� node�� ���� ��� �� ��ȯ
	 * ������ ������ ���� ���⵵ : ��� ȣ��� ���� O(N)��ŭ�� ���� ���⵵�� �䱸��.
	 */
	public static LinkedListNode_2_2 nthToLastR2(LinkedListNode_2_2 head, int k, IntWrapper i) {
		if (head == null) {
			return null;
		}
		LinkedListNode_2_2 node = nthToLastR2(head.next, k, i); // node�� ��������� ��
																// ������ null�� ����
																// indicator�� ��
		i.value = i.value + 1;
		if (i.value == k) {
			return head; // head�� �ڿ��� ���� k��° ��Ҹ� ã���� ��, �ش� ��ҿ� ���� indicator
		}
		return node;
	}
	
	/*
	 * �� ����� p1, p2 2���� �����͸� �̿��� �����. p1�� p2�� ������ �Ÿ��� K��ŭ�̶�� ����� �̿�
	 */
	public static LinkedListNode_2_2 nthToLastR3(LinkedListNode_2_2 head, int k) {
		if (k <= 0) return null;
		LinkedListNode_2_2 p1 = head;
		LinkedListNode_2_2 p2 = head;

		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) return null; // ���� �˻�
			p2 = p2.next;
		}
		if (p2 == null) return null; // ���� �˻�

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		LinkedListNode_2_2 head = new LinkedListNode_2_2(0);
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(7);

		System.out.println(nthToLastR2(head, 2, new IntWrapper()).data);
	}
}
