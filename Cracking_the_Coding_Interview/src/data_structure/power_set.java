// 참고 : http://swlock.blogspot.kr/2016/03/power-set.html
// 참고 : http://swlock.blogspot.kr/2016/06/power-set-2.html	
// 참고 : http://swlock.blogspot.kr/2016/03/dp-power-set-with-dp.html
package data_structure;

//public class power_set {
//
//	static int data[] = { 1, 2, 3, 4 };
//	static int flag[] = { 0, 0, 0, 0 };
//
//	public static void powerset(int n, int depth) {
//		
//		if (n == depth) {
//			int i;
//			System.out.print("{");
//			for (i = 0; i < n; i++) {
//				if (flag[i] == 1)
//					System.out.print(data[i] + " ");
//			}
//			System.out.println("}");
//			return;
//		}
//		
//		flag[depth] = 1;
//		powerset(n, depth + 1);
//		flag[depth] = 0;
//		powerset(n, depth + 1);
//	}
//
//	public static void main(String[] args) {
//		powerset(4, 0);
//	}
//}


// 참고 : http://ide.geeksforgeeks.org/index.php
// A Java program to print all subsets of a set

public class power_set {
	// Print all subsets of given set[]
	static void printSubsets(char set[]) {
		int n = set.length;

		// Run a loop for printing all 2^n
		// subsets one by obe
		for (int i = 0; i < (1 << n); i++) {
			System.out.print("{ ");

			// Print current subset
			for (int j = 0; j < n; j++)

				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
				if ((i & (1 << j)) > 0)
					System.out.print(set[j] + " ");

			System.out.println("}");
		}
	}

	// Driver code
	public static void main(String[] args) {
		char set[] = { 'a', 'b', 'c' };
		printSubsets(set);
	}
}
