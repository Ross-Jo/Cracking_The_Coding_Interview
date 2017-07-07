package data_structure;

class LinkedListNode_2_2 { // Node 클래스
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

class IntWrapper { // Wrapper클래스를 이용해 참조를 통한 값 전달을 흉내냄
	public int value = 0;
}

public class Q_2_2_solution {
	/*
	 * 재귀를 통해 단방향 linked list에서의 뒤에서 부터 k번째 요소를 찾음 다만 여기서는 원소를 반환하지 않고 카운터 값만
	 * 반환함
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
	 * 역시 재귀를 통한 방법인데 wrapper클래스를 활용하여 카운터 값 및 객체를 반환함 head 및 node를 통해 노드 값 반환
	 * 과정을 통제함 공간 복잡도 : 재귀 호출로 인해 O(N)만큼의 공간 복잡도를 요구함.
	 */
	public static LinkedListNode_2_2 nthToLastR2(LinkedListNode_2_2 head, int k, IntWrapper i) {
		if (head == null) {
			return null;
		}
		LinkedListNode_2_2 node = nthToLastR2(head.next, k, i); // node는 결과적으로 맨
																// 마지막 null에 대한
																// indicator가 됨
		i.value = i.value + 1;
		if (i.value == k) {
			return head; // head는 뒤에서 부터 k번째 요소를 찾았을 때, 해당 요소에 대한 indicator
		}
		return node;
	}
	
	/*
	 * 이 방법은 p1, p2 2개의 포인터를 이용한 방법임. p1과 p2가 떨어진 거리가 K만큼이라는 사실을 이용
	 */
	public static LinkedListNode_2_2 nthToLastR3(LinkedListNode_2_2 head, int k) {
		if (k <= 0) return null;
		LinkedListNode_2_2 p1 = head;
		LinkedListNode_2_2 p2 = head;

		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) return null; // 오류 검사
			p2 = p2.next;
		}
		if (p2 == null) return null; // 오류 검사

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
