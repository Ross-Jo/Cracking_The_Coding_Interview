package data_structure;

import java.util.Stack;

class LinkedListNode_2_7{
	LinkedListNode_2_7 next;
	LinkedListNode_2_7 prev;
	LinkedListNode_2_7 last;
	int data;
	
	public LinkedListNode_2_7(int data, LinkedListNode_2_7 next, LinkedListNode_2_7 prev) {
		this.data = data;
		setNext(next);
		setPrevious(prev);
	}

	public LinkedListNode_2_7(int data) {
		this.data = data;
	}

	public LinkedListNode_2_7() {}

	public void setNext(LinkedListNode_2_7 next) {
		this.next = next;
		if (this == last) last = next;
		if (next != null && next.prev != this) next.setPrevious(this);
	}
	
	public void setPrevious(LinkedListNode_2_7 prev) {
		this.prev = prev;
		if (prev != null && prev.next != this) prev.setNext(this);
	}
	
	public LinkedListNode_2_7 appendToTail(int data){
		LinkedListNode_2_7 end = new LinkedListNode_2_7(data);
		LinkedListNode_2_7 n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
		end.prev = n;
		last = end;
		
		return end;
	}
}

class Result{
	public LinkedListNode_2_7 node;
	public boolean result;
	
	public Result(LinkedListNode_2_7 node, boolean result){
		this.node = node;
		this.result = result;
	}
}

public class Q_2_7_solution {
	
	public static boolean isPalindrome_1(LinkedListNode_2_7 head){
		LinkedListNode_2_7 fast = head;
		LinkedListNode_2_7 slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		/* 연결 리스트의 앞 절반을 스택에 쌓는다.
		 * fast runner가 (2배속으로 질주하는) 연결리스트의 끝에 도달했는지 보면, 중간 지점에 다다랐는지 알 수 있다.
		 */
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 리스트 길이가 홀수라면 가운데 원소는 패스
		if(fast!=null) slow = slow.next;
		

		while (slow != null){
			int top = stack.pop().intValue();
			
			// 값이 다르면 회문이 아니다.
			if (top != slow.data) return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static Result isPalindromeRecurse(LinkedListNode_2_7 head, int length){
		if (head == null || length == 0) return new Result(null, true); // 의미 없는 입력에 대한 처리
		else if (length == 1) return new Result(head.next, true); // 회문의 길이가 홀수인 경우
		else if (length == 2) return new Result(head.next.next, head.data==head.next.data); // 회문의 길이가 짝수인 경우
		
		Result res = isPalindromeRecurse(head.next, length-2);
		if (!res.result || res.node == null) return res; // 반환 노드가 없을때나, false값이 있을 때에는 그대로 리턴
		else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public static int listSize(LinkedListNode_2_7 head){
		LinkedListNode_2_7 runner = head;
		int length = 0;
		while(runner!=null){
			length++;
			runner = runner.next;
		}
		return length;
	}
	
	public static boolean isPalindrome_2(LinkedListNode_2_7 head){
		Result p = isPalindromeRecurse(head, listSize(head));
		return p.result;
	}
	
	public static void main(String[] args) {
		LinkedListNode_2_7 head = new LinkedListNode_2_7(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(1);
		
		System.out.println("회문 여부: "+isPalindrome_2(head));
	}
}