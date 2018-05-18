package algorithm.dynamicprogramming.lcs;

public class LPS {
	public String lps(String s) {
		String rs=new StringBuffer(s).reverse().toString();
		int n[][]=new int[s.length()][rs.length()];
		String res="",temp="";
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<rs.length();j++) {
				if(s.charAt(i)==rs.charAt(j)) {
					if(i==0||j==0) {
						n[i][j]=1;
					}else {
						n[i][j]=n[i-1][j-1]+1;
					}
					temp=s.substring(i-n[i][j]+1, i+1);
					for(int k=0;k<temp.length()/2+1;k++) {
						if(temp.charAt(k)!=temp.charAt(temp.length()-k-1))
							temp="";
					}
					if(res.length()<temp.length())
						res=temp;
				}else {
					n[i][j]=0;
				}
			}
		}
		return res;
	}
	public static void main(String[]args) {
		LPS l=new LPS();
		System.out.println(l.lps("abacdfgdcaba"));
	}
}
