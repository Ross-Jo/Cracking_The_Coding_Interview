package data_structure;

class Node_2_5{
	Node_2_5 next = null;
	int data;
	
	public Node_2_5(int data){
		this.data = data;
	}
	
	public void appendToTail(int data){
		Node_2_5 end = new Node_2_5(data);
		Node_2_5 n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_5 {
	
	public static Node_2_5 adder(Node_2_5 head1, Node_2_5 head2){
		int extra = 0, tmp = 0; // extra 
		Node_2_5 result = new Node_2_5(0); // 결과값을 반환할 객체 생성, 하지만 맨 앞의 0(생성 목적으로 사용)은 결과 인식 시 무시해야 함.
		
		while (head1 != null && head2 != null) {
			if ((tmp = head1.data + head2.data + extra) < 10) {
				result.appendToTail(tmp);
				extra = tmp / 10;
			} else {
				result.appendToTail(tmp % 10);
				extra = tmp / 10;
			}
			if (head1.next == null || head2.next == null) break;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if (head1.next != null) {
			while (head1 != null) {
				head1 = head1.next;
				if ((tmp = head1.data + extra) < 10) {
					result.appendToTail(tmp);
					extra = tmp / 10;
				} else {
					result.appendToTail(tmp % 10);
					extra = tmp / 10;
				}
				if (head1.next == null) break;
			}
		}
		else if (head2.next != null) {
			while (head2 != null) {
				head2 = head2.next;
				if ((tmp = head2.data + extra) < 10) {
					result.appendToTail(tmp);
					extra = tmp / 10;
				} else {
					result.appendToTail(tmp % 10);
					extra = tmp / 10;
				}
				if (head2.next == null) break;
			}
		}
		
		if(extra==1) result.appendToTail(1); // extra로 인해 주어진 인자들 중 최고 자릿수를 넘어가는 경우 
		
		result = result.next; // 최초 생성을 위해 적었던 의미 없는 '0' 무시
		return result;
	}
	
	public static void main(String[] args) {
		Node_2_5 head1 = new Node_2_5(9);
		head1.appendToTail(9);
		head1.appendToTail(9);
		
		Node_2_5 head2 = new Node_2_5(1);
		head2.appendToTail(1);
		head2.appendToTail(1);
		
		Node_2_5 result = adder(head1, head2);
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}
}