package algorithm.kmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Kmp {
	public int[] getnext(String ps) {

		char[] p = ps.toCharArray();

		int[] next = new int[p.length];

		next[0] = -1;

		int j = 0;

		int k = -1;

		while (j < p.length - 1) {

			if (k == -1 || p[j] == p[k]) {

				next[++j] = ++k;

			} else {

				k = next[k];

			}

		}

		return next;

	}

	public int[] getNext(String ps) {

		char[] p = ps.toCharArray();

		int[] next = new int[p.length];

		next[0] = -1;

		int j = 0;

		int k = -1;

		while (j < p.length - 1) {

			if (k == -1 || p[j] == p[k]) {

				if (p[++j] == p[++k]) { 
					next[j] = next[k];

				} else {

					next[j] = k;

				}

			} else {

				k = next[k];

			}

		}
		return next;
	}

	public int[] next(String t) {
		int[] next = new int[t.length()];
		next[0] = -1;
		int k = -1;
		int j = 1;
		while (j < t.length()) {
			if (k == -1 || t.charAt(j - 1) == t.charAt(k)) {
				next[j++] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public int[] Next(String t) {
		char c = 0;
		t=t+c;
		int[] next = new int[t.length()];
		next[0] = -1;
		int k = -1;
		int j = 1;
		while (j < t.length()) {
			if (k == -1 || t.charAt(j - 1) == t.charAt(k)) {
				if (t.charAt(j) == t.charAt(++k))
					next[j++] = next[k];
				else
					next[j++] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public Integer[] getCommonString(String s, String t) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int[] next = Next(t);
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
		System.out.println(Arrays.toString(k.Next("aba")));
		System.out.println(Arrays.toString(k.getCommonString("abcabdcabcadbcbabwjehjw", "abc")));
		System.out.println(Arrays.toString(k.getCommonString("ababababafbaba", "aba")));
	}
}
