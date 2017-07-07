package data_structure;

import java.util.Hashtable;

class LinkedListNode_2_1 { // Node Ŭ����
	LinkedListNode_2_1 next = null;
	int data;

	public LinkedListNode_2_1(int data) {
		this.data = data;
	}

	void appendToTail(int data) {
		LinkedListNode_2_1 end = new LinkedListNode_2_1(data);
		LinkedListNode_2_1 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_1_solution {

	// ���۰� �ִ� ���
	public static void deleteDups(LinkedListNode_2_1 n) {
		Hashtable table = new Hashtable(); // Hashtable�� ����ؼ� �ڷ��� Ÿ�� ���� �� ����Ǵ� duplication check�� ���� node���� ������ ����
		LinkedListNode_2_1 previous = null;
		while (n != null) { // ���� �ָ��ؼ� �� ��
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	// ���۰� ���� ���
	public static void deleteDups_m(LinkedListNode_2_1 head){
		if (head == null) return;
		
		LinkedListNode_2_1 current = head;
		while(current != null){
			LinkedListNode_2_1 runner = current;
			while(runner.next!=null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	// �ٸ� �̷��� �� ���, ���� ���⵵�� O(1)�� ������, ���� �ð��� O(N^2)�� �ȴ�.

	public static void main(String args[]) {
		LinkedListNode_2_1 head = new LinkedListNode_2_1(0);

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

		while (head != null) { // ���⵵ �̷� ������ ����ϸ� �Ǵ� ���� �ָ�
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
