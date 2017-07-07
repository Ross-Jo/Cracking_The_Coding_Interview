package data_structure;

/*
 * 코드의 단점. 노드가 가질 수 있는 데이터가 정수로 제한. 중복 체크가 중복 체크를 위해 생성한 임시 배열사이즈 크기 밖에 안됨
 * 중복 체크를 위한 소요 공간 복잡도 O(1)
 * 중복 체크를 위한 시간 복잡도 O(N)
 *  
 */

class Node_2_1 { // Node 클래스
	Node_2_1 next = null;
	int i;

	public Node_2_1(int i) {
		this.i = i;
	}

	void appendToTail(int i) {
		Node_2_1 end = new Node_2_1(i);
		Node_2_1 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_1 {

	public static void discard_duplication(Node_2_1 startNode, Node_2_1 head) {
		boolean[] check_m = new boolean[100]; // 임시 버퍼, 100칸
		Node_2_1 tmp = head;

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
		Node_2_1 head = new Node_2_1(0); // 0 은 header 취급

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