package data_structure;

public class Q_1_1_solution {
	/**
	 * [���������� ������� �� �߿��� ����]
	 * 1. ���ڿ��� ASCII ���ڿ����� �����ڵ� ���ڿ�����. (�ַ�� �ڵ忡���� ASCII���ڿ��� ����)
	 * 
	 * [���� ������ ����ȭ ���]
	 * 1. ���ڿ��� ���̰� ���� ���� ũ�⺸�� Ŭ ��� �ٷ� false�� ��ȯ�ϴ� ��
	 * 
	 * ���ڿ��� ���̰� n�� ��, �Ʒ� �ڵ��� �ð� ���⵵�� O(n) ���� ���⵵�� O(1).
	 * ��Ʈ ���� ���� �ʿ��� ������ 1/8���� ���� �� ����
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
	 * ���ڿ��� �ҹ��� a-z�θ� �����ȴٰ� ����
	 * �� ��� �ϳ��� int�� ��� ����
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26)
			return false;

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) { // 1 ���� �������� val��Ʈ �̵�
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
