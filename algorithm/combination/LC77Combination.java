package algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class LC77Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		combineR(n, 0, l, al, k);
		return al;
	}

	public void combineR(int n, int s, List<Integer> l, List<List<Integer>> al, int k) {
		if (l.size() == k) {
			List<Integer> temp = new ArrayList<Integer>(l);
			al.add(temp);
		} else {
			for (int i = s; i < n; i++) {
				l.add(i + 1);
				combineR(n, i + 1, l, al, k);
				l.remove(l.size() - 1);
			}
		}
	}
}
