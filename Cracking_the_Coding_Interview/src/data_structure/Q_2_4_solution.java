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
			node.next = null; // �뵵�� �������� �����ϱ� ������ chaining�� �߻����� �ʵ��� �ϱ� ����
			if (node.data < x) {
				// ��带 before ����Ʈ�� �������� ����
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				// ��带 after ����Ʈ�� �������� ����
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

		// before����Ʈ�� after����Ʈ�� ����
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	// ������ ������ ���� ����
	public static LinkedListNode_2_4 partition_2(LinkedListNode_2_4 node, int x) {
		LinkedListNode_2_4 beforeStart = null;
		LinkedListNode_2_4 afterStart = null;

		while (node != null) {
			LinkedListNode_2_4 next = node.next;
			if (node.data < x) {
				// before ����Ʈ�� �տ� ��� ����
				node.next = beforeStart;
				beforeStart = node;
			} else {
				// after ����Ʈ�� �տ� ��� ����
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		}
		
		// before ����Ʈ�� ���� ã�� ����, �� ����Ʈ�� �����Ѵ�.
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
