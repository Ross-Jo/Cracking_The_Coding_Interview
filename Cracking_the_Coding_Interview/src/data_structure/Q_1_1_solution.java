package data_structure;

public class Q_1_1_solution {
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		/**
		 * [면접관에게 물어봐야 할 중요한 질문]
		 * 1. 문자열이 ASCII 문자열인지 유니코드 문자열인지. (솔루션 코드에서는 ASCII문자열로 가정)
		 * 
		 * [실행 가능한 최적화 방안]
		 * 1. 문자열의 길이가 문자 집합 크기보다 클 경우 바로 false를 반환하는 것
		 * 
		 */
		String sentence = new String("abcdefghijklmnopqrstuvwxyz");
		System.out.println(isUniqueChars2(sentence));
	}

}
