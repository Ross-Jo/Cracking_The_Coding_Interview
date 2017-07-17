package data_structure;

// 양방향 링크드리스트 노드
class LinkedListNode_2_5 {
	LinkedListNode_2_5 next;
	LinkedListNode_2_5 prev;
	LinkedListNode_2_5 last;
	int data;
	
	// 생성자 #1
	public LinkedListNode_2_5(int data, LinkedListNode_2_5 next, LinkedListNode_2_5 prev) {
		this.data = data;
		setNext(next);
		setPrevious(prev);
	}
	
	// 생성자 #2
	public LinkedListNode_2_5(int data) {
		this.data = data;
	}
	
	// 생성자 #3
	public LinkedListNode_2_5(){}
	
	public void setNext(LinkedListNode_2_5 next){
		this.next = next;
		if(this==last) last = next;
		if(next != null && next.prev != this) next.setPrevious(this);
	}
	
	public void setPrevious(LinkedListNode_2_5 prev){
		this.prev = prev;
		if(prev != null && prev.next != this) prev.setNext(this);
	}
	
	public String printForward(){
		if(next != null) return data + "->" + next.printForward(); // 재귀 방식으로 구현
		else return ((Integer)data).toString();
	}
	
	public LinkedListNode_2_5 clone(){
		LinkedListNode_2_5 next2 = null;
		if(next != null) next2 = next.clone();
		LinkedListNode_2_5 head2 = new LinkedListNode_2_5(data, next2, null);
		return head2;
	}
}

public class Q_2_5_solution {
	public static LinkedListNode_2_5 addLists(LinkedListNode_2_5 l1, LinkedListNode_2_5 l2, int carry){
		if(l1==null && l2 == null && carry ==0 ) return null;
		
		LinkedListNode_2_5 result = new LinkedListNode_2_5();
		
		int value = carry;
		if(l1 != null) value += l1.data;
		if(l2 != null) value += l2.data;
		
		result.data = value % 10;
		
		LinkedListNode_2_5 more = addLists(l1 == null ? null : l1.next, l2==null ? null : l2.next, value >= 10 ? 1 : 0);
		result.setNext(more);
		return result;
	}
	
	public static void main(String[] args) {
		LinkedListNode_2_5 arg_7 = new LinkedListNode_2_5(7);
		LinkedListNode_2_5 arg_1 = new LinkedListNode_2_5(1, null, arg_7);
		LinkedListNode_2_5 arg_6 = new LinkedListNode_2_5(6, null, arg_1);
		
		LinkedListNode_2_5 arg_5 = new LinkedListNode_2_5(5);
		LinkedListNode_2_5 arg_9 = new LinkedListNode_2_5(9, null, arg_5);
		LinkedListNode_2_5 arg_2 = new LinkedListNode_2_5(2, null, arg_9);

		LinkedListNode_2_5 n = addLists(arg_7, arg_5, 0);
		
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}		
	}
}