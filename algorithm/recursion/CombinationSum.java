package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (target < 0)
			return null;
		if (target == 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
			r.add(a);
			return r;
		}
		List<List<Integer>> al = null;
        List<List<Integer>> l = new ArrayList<List<Integer>> ();
		for (int i = 0; i < candidates.length; i++) {
			int []A=new int[candidates.length-i];
			System.arraycopy(candidates, i, A, 0, candidates.length-i);
			al = combinationSum(A, target - candidates[i]);
			if (al != null) {
				for (int j = 0; j < al.size(); j++) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(candidates[i]);
					temp.addAll(al.get(j));
                    l.add(temp);
				}
			}
		}
		return l;
	}
}
