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
		Node_2_4 front = head; // front�� ����Ű�� ������
		Node_2_4 runner = head; // ����Ʈ�� ��ȸ�ϴ� ������
		int length = 1;
		while (head.next != null) {
			head = head.next;
			length++; // ����Ʈ�� ���� ����
		}
		Node_2_4 end = head;
		
		while(front.data > st){ // �Ʒ��� �˰��� ���ϸ� ó�� head�κ��� ��ȸ�ϸ鼭 ������ ���� �ʱ⿡ head�κп� ���� �ʱ� '��' ���� ����
			front = runner.next;
			end.next = runner;
			end = runner;
			runner = front;
		}
		
		for (int i = 0; i < length - 1; i++) {
			Node_2_4 tmp; // �ӽ� ������
			if (runner.next.data < st) { // ���ذ����� ���� ��� front�� ��带 �ٿ���
				if (runner.next.next == null) { // ������ 2��°�� ���� ���� ó��(�ռ� head�κ��� ���� ó���� �Ͱ� ������ ����)
					                          // ex) 1, 2, 3, 4�� ��尡 �ִٰ� �� ��, �Ʒ� �˰����� ����Ʈ�� ��ȸ�ϸ鼭 1, 4�� �ǵ帮�� ����
					end = runner;
					runner.next.next = front;
				}
				tmp = runner.next;

				runner.next = runner.next.next; // runner�� ���� ��ȸ�� ���� �κ�
				tmp.next = front;
				front = tmp; // front ������ ����
			}
			else if (runner.next.data > st) { // ���ذ����� ū ��� end�� ��带 �ٿ���
				tmp = runner.next;

				runner.next = runner.next.next;
				end.next = tmp;
				end = tmp;
				end.next = null; // end ������ ����
			} else { // ���ذ��� ���� ���� �Ѿ
				runner = runner.next;
			}
		}
		end.next = null; // chaining ������ ����
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