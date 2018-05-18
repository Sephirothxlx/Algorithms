package algorithm.dynamicprogramming.lcs;

import java.util.ArrayList;

public class LCS {
	public String lcs(String a, String b) {
		ArrayList<String> r=new ArrayList<String>();	
		String res = "",temp="";
		int[][] n = new int[a.length()][b.length()];
		for (int i = 0; i < a.	length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0) {
						n[i][j]=1;
					} else {
						n[i][j] = n[i - 1][j - 1] + 1;
					}
					temp=a.substring(i-n[i][j]+1, i+1);
					if(temp.length()>res.length()) 
						res=temp;
					else if(temp.length()==res.length())
						r.add(temp);
				} else {
					n[i][j]=0;
				}
			}
		}
	
		return res;
	}
	public static void main(String[]args) {
		LCS l=new LCS();
		String s=l.lcs("abacdfdcaba", "cdfgd");
		System.out.println(s);
	}
}
