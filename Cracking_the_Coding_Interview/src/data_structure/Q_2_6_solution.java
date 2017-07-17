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
			 * 출동 지점을 찾는다. 연결 리스트 안으로 LOOP_SIZE - k만큼 들어간 상태가 된다
			 */
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}	
		
		// 오류 검사. 충돌이 없다면, 루프도 없다
		if(fast==null || fast.next==null) return null;
			
		/* slow를 head로 이동시킨다. Fast는 충돌 지점에 그대로 둔다.
		 * 그 둘은 루프 시작 지점에서 k만큼 떨어져 있다.
		 * 그러므로 같은 속도로 움직이면, 시작점에서 만나게 된다.
		 */
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		// 둘다 루프 시작점을 가리키게 된다
		return fast;
	}
	
	public static void main(String[] args) {
		LinkedListNode_2_6 head = new LinkedListNode_2_6(1);
		head.appendToTail(2);
		LinkedListNode_2_6 target1 = head.appendToTail(3);
		head.appendToTail(4);
		LinkedListNode_2_6 target2 = head.appendToTail(5);
		target2.next = target1;
		
		System.out.println("순환되는 부분의 첫 노드: "+FindBeginning(head).data);
	}
}