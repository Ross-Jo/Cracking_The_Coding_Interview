package data_structure;

class LinkedListNode_2_6{
	LinkedListNode_2_6 next;
	LinkedListNode_2_6 prev;
	LinkedListNode_2_6 last;
	int data;
	boolean touch;
	
	public LinkedListNode_2_6(int data, LinkedListNode_2_6 next, LinkedListNode_2_6 prev) {
		this.data = data;
		setNext(next);
		setPrevious(prev);
	}

	public LinkedListNode_2_6(int data) {
		this.data = data;
		this.touch = false;
	}

	public LinkedListNode_2_6() {}

	public void setNext(LinkedListNode_2_6 next) {
		this.next = next;
		if (this == last) last = next;
		if (next != null && next.prev != this) next.setPrevious(this);
	}
	
	public void setPrevious(LinkedListNode_2_6 prev) {
		this.prev = prev;
		if (prev != null && prev.next != this) prev.setNext(this);
	}
	
	public LinkedListNode_2_6 appendToTail(int data){
		LinkedListNode_2_6 end = new LinkedListNode_2_6(data);
		LinkedListNode_2_6 n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
		end.prev = n;
		last = end;
		return end;
	}
}

public class Q_2_6_solution {
	
	public static LinkedListNode_2_6 FindBeginning(LinkedListNode_2_6 head){
		LinkedListNode_2_6 slow = head;
		LinkedListNode_2_6 fast = head;
		
		while(fast!=null && fast.next!=null){
			/*
			 * �⵿ ������ ã�´�. ���� ����Ʈ ������ LOOP_SIZE - k��ŭ �� ���°� �ȴ�
			 */
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}	
		
		// ���� �˻�. �浹�� ���ٸ�, ������ ����
		if(fast==null || fast.next==null) return null;
			
		/* slow�� head�� �̵���Ų��. Fast�� �浹 ������ �״�� �д�.
		 * �� ���� ���� ���� �������� k��ŭ ������ �ִ�.
		 * �׷��Ƿ� ���� �ӵ��� �����̸�, ���������� ������ �ȴ�.
		 */
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		// �Ѵ� ���� �������� ����Ű�� �ȴ�
		return fast;
	}
	
	public static void main(String[] args) {
		LinkedListNode_2_6 head = new LinkedListNode_2_6(1);
		head.appendToTail(2);
		LinkedListNode_2_6 target1 = head.appendToTail(3);
		head.appendToTail(4);
		LinkedListNode_2_6 target2 = head.appendToTail(5);
		target2.next = target1;
		
		System.out.println("��ȯ�Ǵ� �κ��� ù ���: "+FindBeginning(head).data);
	}
}