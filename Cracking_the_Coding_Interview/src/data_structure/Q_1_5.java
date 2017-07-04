package data_structure;

public class Q_1_5 {
	public static String compression(String s){
		int counter = 1;
		char tmp;
		String result = "";
		
		for(int i=0; i<s.length()-1; i++){
			if((tmp = s.charAt(i))==s.charAt(i+1)){
				counter++;
			}
			else{
				result = result.concat(Character.toString(tmp));
				result = result.concat(Integer.toString(counter));
				counter = 1;
				tmp = s.charAt(i+1);
			}
			
			if(i==s.length()-2){
				result = result.concat(Character.toString(tmp));
				result = result.concat(Integer.toString(counter));
			}
		}
		
		if(result.length()>=s.length()){
			result = s;
		}
		
		return result;
	}
	
	public static void main(String args[]){
		String s = "aaaeeeeddf";
		System.out.println(compression(s));
	}
}
