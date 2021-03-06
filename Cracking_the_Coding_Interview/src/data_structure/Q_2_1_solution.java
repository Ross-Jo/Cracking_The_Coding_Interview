package data_structure;

import java.util.Hashtable;

class LinkedListNode_2_1 { // Node 클래스
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

	// 버퍼가 있는 경우
	public static void deleteDups(LinkedListNode_2_1 n) {
		Hashtable table = new Hashtable(); // Hashtable을 사용해서 자료형 타입 제약 및 연결되는 duplication check를 위한 node갯수 제약을 없앰
		LinkedListNode_2_1 previous = null;
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
	
	// 버퍼가 없는 경우
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
	// 다만 이렇게 할 경우, 공간 복잡도는 O(1)이 되지만, 수행 시간은 O(N^2)이 된다.

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

		while (head != null) { // 여기도 이런 식으로 출력하면 되는 것을 주목
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
