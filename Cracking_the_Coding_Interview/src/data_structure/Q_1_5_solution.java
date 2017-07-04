package data_structure;

public class Q_1_5_solution {
	// �ð� ���⵵ : O(p+k^2), p:���� ���ڿ��� ����, k:���� ���ڰ� ���ӵǴ� �κ�
	public static String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count; // String �����ϴ� ��� �� ����. ������ �� ������
											// O(n^2)�� �ð� ���⵵�� ����
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}

	public static String compressBetter(String str) {
		/* ���� ����� ���� ���ڿ����� ��������� �˻� */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		StringBuffer mystr = new StringBuffer(); // �ð� ���⵵�� ���̱� ����
													// StringBuffer���.
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}

		/**
		 * �ż��� �� �κп��� ���������� ���ڿ��� ������ �ʿ䰡 ����. �� ������ �κп��� �ݺ��Ǵ� ���ڿ��� ���� ���������� �����Ǵ�
		 * ���� ��� ���ڿ��� �ݿ����� �ʾұ� ����.
		 */
		mystr.append(last);
		mystr.append(count);
		return mystr.toString(); // stringBuffer�� ���� ��Ŀ� �ָ��� ��
	}

	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		char[] array = new char[size]; // size�� �̸� �˾Ƴ� �� �ֱ⿡ �̷��� ����� �迭 �� ������ ����
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array); // char[]�� String���� �����ϰ� ��ȯ�� �� �ִٴ� ��ǿ� �ָ�
	}

	static int countCompression(String str) {
		if (str == null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length(); // ���� return ���ڿ���
															// ���̸� �����ϱ� ����.
															// count�� 1�ڸ���,
															// 2�ڸ���, 3�ڸ��� �� �̻�
															// �� �� ����
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;

		/*
		 * �Ʒ��� �۾��� �ϴ� ���� : count�� char[]�� array�� ���� �ֱ� ���Ͽ�.
		 */
		char[] cnt = String.valueOf(count).toCharArray();

		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index; // array�� index�� ��ȯ
	}

	public static void main(String[] args) {
		String s = "aaaeeeeeeeeedddddddddddddeeeeffffffffffxxxxxxxxxxxdf";

		long start = System.currentTimeMillis();
		System.out.println(compressBad(s));
		long end = System.currentTimeMillis();
		System.out.println("���� �ð� : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(compressBetter(s));
		end = System.currentTimeMillis();
		System.out.println("���� �ð� : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(compressAlternate(s));
		end = System.currentTimeMillis();
		System.out.println("���� �ð� : " + (end - start));

	}

}
