package algorithm.leetcodecontest.contest104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC916 {
	public long getMultiply(String s) {
		int p[] = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97, 101 };
		long re = 1;
		for (int i = 0; i < s.length(); i++) {
			re *= p[s.charAt(i) - 'a'];
		}
		return re;
	}

	public List<String> wordSubsets(String[] A, String[] B) {
		long big = 0;
		long[] ff = new long[B.length];
		for (int i = 0; i < B.length; i++) {
			ff[i] = getMultiply(B[i]);
			if (ff[i] > big)
				big = ff[i];
		}
		long small = getMultiply(A[0]);
		List<String> l = new ArrayList<String>();
		for (int j = 0; j < A.length; j++) {
			int t = 0;
			long x = getMultiply(A[j]);
			if (j == 0 || x % small != 0)
				for (int i = 0; i < B.length; i++) {
					if (x % ff[i] != 0) {
						t = 1;
						break;
					}
				}
			if (t == 0) {
				if (small < x)
					small = x;
				l.add(A[j]);
			}
		}
		return l;
	}

	public static void main(String[] args) {
		LC916 l = new LC916();
		System.out.println(l.wordSubsets(new String[] { "acaac", "cccbb", "aacbb", "caacc", "bcbbb" },
				new String[] { "c", "cc", "b" }));
	}
}
