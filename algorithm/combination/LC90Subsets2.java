package algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90Subsets2 {
	public void combine(int[] nums, int start, List<List<Integer>> l, List<Integer> al, int k) {
		if (al.size() == k) {
			List<Integer> temp = new ArrayList<Integer>(al);
			l.add(temp);
		} else {
			int d = nums[0] - 1;
			for (int i = start; i < nums.length; i++) {
				if (d == nums[i])
					continue;
				else {
					d = nums[i];
					al.add(nums[i]);
					combine(nums, i + 1, l, al, k);
					al.remove(al.size() - 1);
				}
			}
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i <= nums.length; i++) {
			combine(nums, 0, l, al, i);
		}
		return l;
	}
}
