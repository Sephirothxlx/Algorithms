package algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
	public void combineR(int[] nums, int s, List<Integer> l, List<List<Integer>> al, int k) {
		if (l.size() == k) {
			List<Integer> temp = new ArrayList<Integer>(l);
			al.add(temp);
		} else {
			for (int i = s; i < nums.length; i++) {
				l.add(nums[i]);
				combineR(nums, i + 1, l, al, k);
				l.remove(l.size() - 1);
			}
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i <= nums.length; i++) {
			combineR(nums, 0, l, al, i);
		}
		return al;
	}
}
