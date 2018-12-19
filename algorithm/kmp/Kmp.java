package algorithm.kmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Kmp {
	public int[] getnext(String ps) {
		char[] p = ps.toCharArray();
		int[] next = new int[p.length+1];
		next[0] = -1;
		int i=-1;
		int j=0;
		while(j<p.length){
			if(i==-1||p[i]==p[j]){
				next[++j]=++i;
			}else{
				i=next[i];
			}
		}
		return next;

	}

	public Integer[] getCommonString(String s, String t) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int[] next = getnext(t);
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
				if (j == t.length()) {
					al.add(i - t.length());
					j = next[j]==-1?0:next[j];
				}
			} else {
				if (next[j] == -1) {
					i++;
					j = 0;
				} else {
					j = next[j];
				}
			}
		}
		return al.toArray(new Integer[] {});
	}

	public static void main(String[] args) {
		Kmp k = new Kmp();
		System.out.println(Arrays.toString(k.getCommonString("abcabdcabcadbcbabwjehjw", "abc")));
		System.out.println(Arrays.toString(k.getCommonString("ababababafbaba", "aba")));
	}
}
