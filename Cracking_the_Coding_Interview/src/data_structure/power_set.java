// Âü°í : http://swlock.blogspot.kr/2016/03/power-set.html
package data_structure;

public class power_set {

	static int data[] = { 1, 2, 3, 4 };
	static int flag[] = { 0, 0, 0, 0 };

	public static void powerset(int n, int depth) {
		
		if (n == depth) {
			int i;
			System.out.print("{");
			for (i = 0; i < n; i++) {
				if (flag[i] == 1)
					System.out.print(data[i] + " ");
			}
			System.out.println("}");
			return;
		}
		
		flag[depth] = 1;
		powerset(n, depth + 1);
		flag[depth] = 0;
		powerset(n, depth + 1);
	}

	public static void main(String[] args) {
		powerset(4, 0);
	}
}