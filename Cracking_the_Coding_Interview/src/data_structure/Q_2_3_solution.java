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
 * �� ������ ��� ������ ���̵������ ��Ȯ���� �ʾ� �ؼ��� ���� �� �ֱ⿡ ���� �̿� ����� ������ ���� �ȴٸ� �����ڿ���
 * Ŀ�´����̼��� ���� Ȯ���� ���̵������ �޾� �� �ʿ䰡 ����.
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
		LinkedListNode_2_3 head = new LinkedListNode_2_3(0); // 0 �� header ���
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);

		deleteNode(head.next.next); // ����� �ִ� ����

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}