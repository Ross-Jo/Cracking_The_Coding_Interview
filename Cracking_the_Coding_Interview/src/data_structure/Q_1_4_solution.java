package data_structure;

public class Q_1_4_solution {

	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
//		str[newLength] = '\0';

		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength -= 1;
			}
		}
	}

	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		char[] input_array = input.toCharArray();
		
		replaceSpaces(input_array, input.length() - 4);
		
		System.out.println(input_array);
	}
}
