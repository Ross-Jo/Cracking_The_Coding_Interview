package data_structure;
/**
 * input�� �ƽ�Ű �ڵ��� ����
 * ��ҹ��� ������ �ִٰ� ����
 */
public class Q_1_3 {
	public static boolean permutation_check(String a, String b) {
		if (a != null && b != null) {
			
			int[] alphabet = new int[256];
			for (int i = 0; i < a.length(); i++) {
				alphabet[(int) a.charAt(i)]++;
			}
			for (int i = 0; i < b.length(); i++) {
				alphabet[(int) b.charAt(i)]--;
			}
			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i] != 0)
					return false;
			}
			return true;
		} else {
			System.out.println("���ڸ� �ٸ��� �Է��Ͻÿ�");
			return false;
		}
	}

	public static void main(String[] args) {
		String a = "Good";
		String b = "Gog";
		System.out.println(permutation_check(a, b));
	}
}