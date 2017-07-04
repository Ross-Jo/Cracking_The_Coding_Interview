package data_structure;

public class Q_1_1_solution {
	/**
	 * [면접관에게 물어봐야 할 중요한 질문]
	 * 1. 문자열이 ASCII 문자열인지 유니코드 문자열인지. (솔루션 코드에서는 ASCII문자열로 가정)
	 * 
	 * [실행 가능한 최적화 방안]
	 * 1. 문자열의 길이가 문자 집합 크기보다 클 경우 바로 false를 반환하는 것
	 * 
	 * 문자열의 길이가 n일 때, 아래 코드의 시간 복잡도는 O(n) 공간 복잡도는 O(1).
	 * 비트 벡터 사용시 필요한 공간을 1/8까지 줄일 수 있음
	 */	
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
	
	/**
	 * 문자열이 소문자 a-z로만 구성된다고 가정
	 * 이 경우 하나의 int만 사용 가능
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26)
			return false;

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) { // 1 값을 왼쪽으로 val비트 이동
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String sentence = new String("abcdefghijklmnopqrstuvwxyz");
		System.out.println(isUniqueChars(sentence));
	}

}
