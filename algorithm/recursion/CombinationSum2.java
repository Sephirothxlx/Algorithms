package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(target<0)
			return null;
		if(target==0){
			ArrayList<Integer> t=new ArrayList<Integer>();
			ArrayList<List<Integer>> r=new ArrayList<List<Integer>>();
			r.add(t);
			return r;
		}
		Arrays.sort(candidates);
		List<List<Integer>> al = null;
        List<List<Integer>> l = new ArrayList<List<Integer>> ();
        int t=Integer.MAX_VALUE;
		for(int i=0;i<candidates.length;i++){
			if(t==candidates[i])
				continue;
			t=candidates[i];
			int []A=new int[candidates.length-i-1];
			System.arraycopy(candidates, i+1, A, 0, candidates.length-i-1);
			al = combinationSum2(A, target - candidates[i]);
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
