package data_structure;

/*
 * 코드의 단점. 노드가 가질 수 있는 데이터가 정수로 제한. 중복 체크가 중복 체크를 위해 생성한 임시 배열사이즈 크기 밖에 안됨
 * 중복 체크를 위한 소요 공간 복잡도 O(1)
 * 중복 체크를 위한 시간 복잡도 O(N)
 *  
 */

class Node { // Node 클래스
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
		boolean[] check_m = new boolean[100]; // 임시 버퍼, 100칸
		Node tmp = head;

		while (startNode.next != null) {
			if (check_m[startNode.i]) {
				tmp.next = startNode.next; // 후행포인터, 시작점 head
				startNode = startNode.next; // 선행포인터, 시작점 head.next
				continue;
			}
			check_m[startNode.i] = true; // 중복 체크를 위한 표시
			tmp = startNode;
			startNode = startNode.next;
		}
		if (check_m[startNode.i]) { // 마지막 노드에 대한 중복 체크를 위함
			tmp.next = startNode.next;
			startNode = startNode.next;
		}

	}

	public static void main(String[] args) {
		Node head = new Node(0); // 0 은 header 취급

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