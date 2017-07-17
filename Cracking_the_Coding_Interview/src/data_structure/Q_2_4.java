package data_structure;

class Node_2_4 {
	Node_2_4 next;
	int data;

	public Node_2_4(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		Node_2_4 end = new Node_2_4(data);
		Node_2_4 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}

public class Q_2_4 {

	public static Node_2_4 semi_sort(Node_2_4 head, int st) {
		Node_2_4 front = head; // front를 가리키는 포인터
		Node_2_4 runner = head; // 리스트를 순회하는 포인터
		int length = 1;
		while (head.next != null) {
			head = head.next;
			length++; // 리스트의 길이 추출
		}
		Node_2_4 end = head;
		
		while(front.data > st){ // 아래의 알고리즘에 의하면 처음 head부분은 순회하면서 정렬이 되지 않기에 head부분에 대한 초기 '선' 정렬 시행
			front = runner.next;
			end.next = runner;
			end = runner;
			runner = front;
		}
		
		for (int i = 0; i < length - 1; i++) {
			Node_2_4 tmp; // 임시 포인터
			if (runner.next.data < st) { // 기준값보다 작은 경우 front에 노드를 붙여줌
				if (runner.next.next == null) { // 끝에서 2번째인 경우는 따로 처리(앞서 head부분을 따로 처리한 것과 동일한 이유)
					                          // ex) 1, 2, 3, 4의 노드가 있다고 할 때, 아래 알고리즘이 리스트를 순회하면서 1, 4를 건드리지 못함
					end = runner;
					runner.next.next = front;
				}
				tmp = runner.next;

				runner.next = runner.next.next; // runner의 다음 순회를 위한 부분
				tmp.next = front;
				front = tmp; // front 포인터 갱신
			}
			else if (runner.next.data > st) { // 기준값보다 큰 경우 end에 노드를 붙여줌
				tmp = runner.next;

				runner.next = runner.next.next;
				end.next = tmp;
				end = tmp;
				end.next = null; // end 포인터 갱신
			} else { // 기준값과 같은 경우는 넘어감
				runner = runner.next;
			}
		}
		end.next = null; // chaining 방지를 위함
		return front;
	}

	public static void main(String[] args) {
		
		Node_2_4 head = new Node_2_4(7);
		head.appendToTail(6);
		head.appendToTail(5);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(1);
		head.appendToTail(0);
		Node_2_4 n = semi_sort(head, 4);
		
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}		
	}
}