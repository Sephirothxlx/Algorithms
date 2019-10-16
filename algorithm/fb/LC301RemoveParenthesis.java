package algorithm.fb;

public class LC301RemoveParenthesis {
	public static String get(String s){
		int count=0;
		String temp="";
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='('){
				count++;
			}else 
				count--;
			if(count>=0){
				temp+=c;
			}else {
				count++;
			}
		}
		if(count==0)
			return temp;
		count=0;
		String temp2="";
		for(int i=temp.length()-1;i>=0;i--){
			char c=temp.charAt(i);
			if(c==')'){
				count++;
			}else 
				count--;
			if(count>=0){
				temp2=c+temp2;
			}else {
				count++;
			}
		}
		return temp2;
	}
	
	public static void main(String[]args) {
		System.out.println(get("()())(()"));
	}
}
