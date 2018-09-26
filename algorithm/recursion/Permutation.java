package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public void permute1(int[] nums, int s, List<List<Integer>> al) {
		if (s == nums.length - 1) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				l.add(nums[i]);
			}
			al.add(l);
		} else {
			for (int i = s; i < nums.length; i++) {
				int temp = nums[s];
				nums[s] = nums[i];
				nums[i] = temp;
				permute1(nums, s + 1, al);
				temp = nums[s];
				nums[s] = nums[i];
				nums[i] = temp;
			}
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		permute1(nums, 0, al);
		return al;
	}
}
