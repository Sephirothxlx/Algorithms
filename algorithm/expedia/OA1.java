package algorithm.expedia;

public class OA1 {
	public String find(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.length()%2==1&&i==s.length()/2)
				continue;
			if(s.charAt(i)!='a') {
				return s.substring(0,i)+'a'+s.substring(i+1);
			}
		}
		return "IMPOSSIBLE";
	}
	
	public static void main(String[]args) {
		OA1 o=new OA1();
		System.out.println(o.find("bab"));
	}
}
