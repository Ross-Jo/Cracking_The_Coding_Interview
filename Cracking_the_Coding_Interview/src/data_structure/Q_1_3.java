package data_structure;
/**
 * input은 아스키 코드라고 가정
 * 대소문자 구분이 있다고 가정
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
			System.out.println("인자를 바르게 입력하시오");
			return false;
		}
	}

	public static void main(String[] args) {
		String a = "Good";
		String b = "Gog";
		System.out.println(permutation_check(a, b));
	}
}