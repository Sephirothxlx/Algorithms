package algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC60CantorExpand {
	public String getPermutation(int n, int k) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			l.add(i + 1);
		}
		int[] factorial = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0)
				factorial[0] = 1;
			else
				factorial[i] = factorial[i - 1] * i;
		}
		k--;
		String s = "";
		for (int i = n - 1; i >= 0; i--) {
			int m = k / factorial[i];
			k = k % factorial[i];
			int temp = l.get(m);
			s += (temp + "");
			l.remove(m);
		}
		return s;
	}
}
