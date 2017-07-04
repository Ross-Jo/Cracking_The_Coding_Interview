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
		 * [���������� ������� �� �߿��� ����]
		 * 1. ���ڿ��� ASCII ���ڿ����� �����ڵ� ���ڿ�����. (�ַ�� �ڵ忡���� ASCII���ڿ��� ����)
		 * 
		 * [���� ������ ����ȭ ���]
		 * 1. ���ڿ��� ���̰� ���� ���� ũ�⺸�� Ŭ ��� �ٷ� false�� ��ȯ�ϴ� ��
		 * 
		 */
		String sentence = new String("abcdefghijklmnopqrstuvwxyz");
		System.out.println(isUniqueChars2(sentence));
	}

}
