package data_structure;

public class Q_1_3_solution {
	// solution method #1
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content); // java.util.Arrays.sort �ָ�
		return new String(content); // ���� ��� �ָ�
	}

	public static boolean permutation_1(String s, String t) {
		if (s.length() != t.length())
			return false;
		return sort(s).equals(sort(t)); // equals �ָ�
	}

	// solution method #2
	public static boolean permutation_2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[256];

		char[] s_array = s.toCharArray(); // array�� ���� for-each���� �� Ȱ������
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "Good";
		String b = "Gog";
		System.out.println(permutation_1(a, b));
	}
}
