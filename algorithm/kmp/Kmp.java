package algorithm.kmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Kmp {
	public int[] getnext(String ps) {
		char[] p = ps.toCharArray();
		int[] next = new int[p.length];
		//next array means the length of prefix that is equal to suffix
		next[0] = 0;
		int i=1;
		int j=0;
		while(i<p.length){
			if(p[i]==p[j]){
				next[i++]=++j;
			}else{
				if(j>0) {
					j=next[j-1];
				}else {
					next[i++]=j;
				}
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
				if(j==t.length()) {
					al.add(i-t.length());
					j=next[j-1];
				}
			} else {
				if(j>0) {
					j=next[j-1];
				}else {
					i++;
				}
			}
		}
		//use generic
		return al.toArray(new Integer[] {});
	}

	public static void main(String[] args) {
		Kmp k = new Kmp();
		System.out.println(Arrays.toString(k.getCommonString("abcabdcabcadbcbabwjehjw", "abc")));
		System.out.println(Arrays.toString(k.getCommonString("aabaabaaasdaabaa", "aabaa")));
		System.out.println(Arrays.toString(k.getCommonString("aacaacaaa", "aa")));
	}
}
