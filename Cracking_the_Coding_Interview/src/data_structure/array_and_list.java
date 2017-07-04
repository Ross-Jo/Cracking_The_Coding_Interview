package data_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class array_and_list {
	
	// HashMap : 시간복잡도 - O(log n)
	public HashMap<Integer, Student> buildMap(Student[] students){
		HashMap<Integer, Studnet> map = new HashMap<Integer, Student>();
		for (Student s : students) map.put(s.getId(), s);
		return map;
	}
	
	// ArrayList : 시간복잡도 - O(1), 배열이 꽉 차서 크기가 2배 늘어나는 데 걸리는 시간 : O(n) 하지만 이런 경우는 그리 자주 일어나는 경우가 아니기 때문에 전체적인 시간 복잡도는 O(1) 정도라고 보면 됨
	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
	
	public static void main(String args[]){
		
	}
}
