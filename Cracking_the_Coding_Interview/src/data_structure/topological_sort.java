package data_structure;

// 제약조건 : cycle이 있으면 사용하지 못한다. 
public class topological_sort {

	/*
	 * 
	 * Topological Sort Algorithm
	 * 
	 * G=(V,E) // 방향 그래프의 정보를 입력한다.
	 * 
	 * 모든 정점의 진입 차수를 계산 
	 * if(진입 차수가 0인 정점이 하나도 없다면) 
	 * Then 위상 정렬 불가능 // 사이클 존재하기 때문
	 * 
	 * else 
	 * { 
	 *  V(진입 차수 == 0) 출력
	 *  V(진입 차수 == 0)와 V와 연결된 E삭제 
	 *  각 정점의 차수 진입차수 수정 
	 * }
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
