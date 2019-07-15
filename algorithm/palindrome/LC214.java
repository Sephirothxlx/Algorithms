package algorithm.palindrome;

public class LC214 {
	public String shortestPalindrome(String s) {
		if(s==null||s.length()==0) {
			return s;
		}
		StringBuilder sb=new StringBuilder(s);
		String ss=s+"#"+sb.reverse().toString();
		int[]next=new int[ss.length()];
		next[0]=0;
		int i=1,j=0;
		while(i<ss.length()) {
			if(ss.charAt(i)==ss.charAt(j)) {
				next[i++]=++j;
			}else {
				if(j>0) {
					j=next[j-1];
				}else {
					next[i++]=j;
				}
			}
		}
		String x=s.substring(next[ss.length()-1]);
		StringBuilder sb2=new StringBuilder(x);
		return sb2.reverse().toString()+s.substring(0,next[ss.length()-1])+x;
	}
}
