package data_structure;

/*
 * ���̵���� �ٽ� : xy = s1�̰� rotation�� yx = s2�� ���� ��, yx�� ������ xyxy�� �κ� ���ڿ� 
 */

public class Q_1_8_solution {
	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len==s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return s1s1.contains(s2); // return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottlwaterlwll";
		String s2 = "bottlwaterlwllwater";
		System.out.println(isRotation(s1, s2));
	}
}