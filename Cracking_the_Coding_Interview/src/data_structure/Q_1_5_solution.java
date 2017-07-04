package data_structure;

public class Q_1_5_solution {
	// 시간 복잡도 : O(p+k^2), p:원래 문자열의 길이, k:같은 문자가 연속되는 부분
	public static String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count; // String 결합하는 방법 잘 보기. 하지만 이 연산은
											// O(n^2)의 시간 복잡도를 가짐
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}

	public static String compressBetter(String str) {
		/* 압축 결과가 원래 문자열보다 길어지는지 검사 */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		StringBuffer mystr = new StringBuffer(); // 시간 복잡도를 줄이기 위해
													// StringBuffer사용.
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
		 * 매서드 끝 부분에서 최종적으로 문자열을 갱신할 필요가 있음. 맨 마지막 부분에서 반복되는 문자열은 아직 최종적으로 생성되는
		 * 압축 결과 문자열에 반영되지 않았기 때문.
		 */
		mystr.append(last);
		mystr.append(count);
		return mystr.toString(); // stringBuffer의 리턴 방식에 주목할 것
	}

	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		char[] array = new char[size]; // size를 미리 알아낼 수 있기에 이러한 방식의 배열 선 생성이 가능
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
		return String.valueOf(array); // char[]도 String으로 간단하게 반환할 수 있다는 사실에 주목
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
				size += 1 + String.valueOf(count).length(); // 순수 return 문자열의
															// 길이를 측정하기 위함.
															// count는 1자리도,
															// 2자리도, 3자리도 그 이상도
															// 될 수 있음
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
		 * 아래의 작업을 하는 이유 : count를 char[]인 array에 집어 넣기 위하여.
		 */
		char[] cnt = String.valueOf(count).toCharArray();

		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index; // array의 index를 반환
	}

	public static void main(String[] args) {
		String s = "aaaeeeeeeeeedddddddddddddeeeeffffffffffxxxxxxxxxxxdf";

		long start = System.currentTimeMillis();
		System.out.println(compressBad(s));
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(compressBetter(s));
		end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(compressAlternate(s));
		end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start));

	}

}
