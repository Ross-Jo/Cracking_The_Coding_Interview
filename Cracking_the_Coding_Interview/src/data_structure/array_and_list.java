package data_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class array_and_list {
	
	// HashMap : �ð����⵵ - O(log n)
	public HashMap<Integer, Student> buildMap(Student[] students){
		HashMap<Integer, Studnet> map = new HashMap<Integer, Student>();
		for (Student s : students) map.put(s.getId(), s);
		return map;
	}
	
	// ArrayList : �ð����⵵ - O(1), �迭�� �� ���� ũ�Ⱑ 2�� �þ�� �� �ɸ��� �ð� : O(n) ������ �̷� ���� �׸� ���� �Ͼ�� ��찡 �ƴϱ� ������ ��ü���� �ð� ���⵵�� O(1) ������� ���� ��
	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
	
	public static void main(String args[]){
		
	}
}
