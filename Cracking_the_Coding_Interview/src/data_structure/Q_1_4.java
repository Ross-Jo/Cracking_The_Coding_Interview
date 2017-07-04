package data_structure;

public class Q_1_4 {
	public static char[] replace(String s, int l) {
		char[] c_array = new char[s.length()];
		char[] i_array = s.toCharArray();
		int indicator = l;
		
		int index = 0;
		for (char i : i_array) {
			c_array[index++] = i;
		}

		for (int i = l - 1; i >= 0; i--) {
			if (c_array[i] == ' ') {
				for (int j = indicator - 1; j > i; j--) {
					c_array[j + 2] = c_array[j];
				}
				c_array[i] = '%';
				c_array[i + 1] = '2';
				c_array[i + 2] = '0';
				indicator += 2;
			}
		}
		return c_array;
	}

	public static void main(String[] args) {
		String input = "Mr John Smith Adam James        ";
		System.out.println(replace(input, input.length() - 8)); // 4 = µÞ °ø¹é °ø°£ÀÇ
																// °¹¼ö
	}
}