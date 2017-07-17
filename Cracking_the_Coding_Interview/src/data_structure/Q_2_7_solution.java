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
		
		/* ���� ����Ʈ�� �� ������ ���ÿ� �״´�.
		 * fast runner�� (2������� �����ϴ�) ���Ḯ��Ʈ�� ���� �����ߴ��� ����, �߰� ������ �ٴٶ����� �� �� �ִ�.
		 */
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// ����Ʈ ���̰� Ȧ����� ��� ���Ҵ� �н�
		if(fast!=null) slow = slow.next;
		

		while (slow != null){
			int top = stack.pop().intValue();
			
			// ���� �ٸ��� ȸ���� �ƴϴ�.
			if (top != slow.data) return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static Result isPalindromeRecurse(LinkedListNode_2_7 head, int length){
		if (head == null || length == 0) return new Result(null, true); // �ǹ� ���� �Է¿� ���� ó��
		else if (length == 1) return new Result(head.next, true); // ȸ���� ���̰� Ȧ���� ���
		else if (length == 2) return new Result(head.next.next, head.data==head.next.data); // ȸ���� ���̰� ¦���� ���
		
		Result res = isPalindromeRecurse(head.next, length-2);
		if (!res.result || res.node == null) return res; // ��ȯ ��尡 ��������, false���� ���� ������ �״�� ����
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
		
		System.out.println("ȸ�� ����: "+isPalindrome_2(head));
	}
}