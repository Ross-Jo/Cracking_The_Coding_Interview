package data_structure;

public class Q_1_1 {
	static boolean check_unique_char(String sentence) {
		// 문자열은 A-Za-z로 가정, 대/소문자는 다른 문자로 가정, 문자열은 ASCII code로 가정
		int[][] alphabet = new int[2][52];
		for (int i = 0; i < 52; i++) {
			if (i < 26)
				alphabet[0][i] = i + 65; //
			else
				alphabet[0][i] = i + 71;
			alphabet[1][i] = 0;
		}

		int hit;
		for (int i = 0; i < sentence.length(); i++) {
			hit = 0;
			for (int j = 0; j < 52; j++) {
				if ((int) sentence.charAt(i) == alphabet[0][j] && alphabet[1][j] == 0) {
					alphabet[1][j] = 1;
					hit = 1;
					break;
				}
			}
			if (hit == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		String sentence = new String("abcdefghijklmnopqrstuvwxyz");
		System.out.println(check_unique_char(sentence));

	}
}
