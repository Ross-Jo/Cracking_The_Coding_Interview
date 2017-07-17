package data_structure;

class LinkedListNode_2_4 {
	LinkedListNode_2_4 next;
	int data;

	public LinkedListNode_2_4(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		LinkedListNode_2_4 end = new LinkedListNode_2_4(data);
		LinkedListNode_2_4 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_4_solution {

	public static LinkedListNode_2_4 partition_1(LinkedListNode_2_4 node, int x) {
		LinkedListNode_2_4 beforeStart = null;
		LinkedListNode_2_4 beforeEnd = null;
		LinkedListNode_2_4 afterStart = null;
		LinkedListNode_2_4 afterEnd = null;

		while (node != null) {
			LinkedListNode_2_4 next = node.next;
			node.next = null; // 노도를 마지막에 삽입하기 때문에 chaining이 발생하지 않도록 하기 위함
			if (node.data < x) {
				// 노드를 before 리스트의 마지막에 삽입
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				// 노드를 after 리스트의 마지막에 삽입
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) {
			return afterStart;
		}

		// before리스트와 after리스트를 결합
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	// 포인터 갯수를 줄인 버전
	public static LinkedListNode_2_4 partition_2(LinkedListNode_2_4 node, int x) {
		LinkedListNode_2_4 beforeStart = null;
		LinkedListNode_2_4 afterStart = null;

		while (node != null) {
			LinkedListNode_2_4 next = node.next;
			if (node.data < x) {
				// before 리스트의 앞에 노드 삽입
				node.next = beforeStart;
				beforeStart = node;
			} else {
				// after 리스트의 앞에 노드 삽입
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		}
		
		// before 리스트의 끝을 찾은 다음, 두 리스트를 결합한다.
		LinkedListNode_2_4 head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;

		return head;
	}
	
	public static void main(String args[]){
		LinkedListNode_2_4 head = new LinkedListNode_2_4(7);
		
		head.appendToTail(6);
		head.appendToTail(5);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(1);
		head.appendToTail(0);
		
		LinkedListNode_2_4 n = partition_2(head, 4);
		
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
}
