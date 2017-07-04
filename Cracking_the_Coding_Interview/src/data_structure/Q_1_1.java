package data_structure;

public class Q_1_1 {
	static boolean check_unique_char(String sentence) {
		// ���ڿ��� A-Za-z�� ����, ��/�ҹ��ڴ� �ٸ� ���ڷ� ����, ���ڿ��� ASCII code�� ����
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
