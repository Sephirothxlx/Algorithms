package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<Integer>();
		Arrays.sort(nums);
		List<Integer> l = new ArrayList<Integer>();
		int count[] = new int[nums.length];
		count[0] = 1;
		int max = 0;
		int index = -1;
		for (int i = 1; i < nums.length; i++) {
			count[i] = 1;
			for (int j = i; j >= 0; j--) {
				if (nums[j] % nums[i] == 0) {
					count[i] += count[j];
					if (max < count[i]) {
						max = count[i];
						index = i;
					}
					break;
				}
			}
		}
		for (int i = index; i >= 0; i--) {
			if (nums[i] % nums[index] == 0)
				l.add(nums[i]);
		}
		return l;
	}
}
