package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static List<Integer> getList(int j, int[] candidates, int target) {
		if (target == 0)
			return new ArrayList<Integer>();
		if (target < 0)
			return null;
		List<Integer> al = null;
		for (int x = j; x < candidates.length; x++) {
			List<Integer> t= getList(x, candidates, target - candidates[x]);
			if (t != null) {
				al = new ArrayList<Integer>();
				al.add(candidates[x]);
				al.addAll(t);
			}
		}
		return al;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		for (int i = 0; i < candidates.length; i++) {
			List<Integer> al = getList(i, candidates, target - candidates[i]);
			if (al != null) {
				List<Integer> t = new ArrayList<Integer>();
				t.add(candidates[i]);
				t.addAll(al);
				l.add(t);
			}
		}
		return l;
	}
}
