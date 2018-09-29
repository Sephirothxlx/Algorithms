package algorithm.permutation;

import java.util.Arrays;

public class KthPermutation {
	public String nextPermutation(int[] nums) {
		int tag = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] <= nums[i - 1]) {
				continue;
			} else {
				tag = i;
				break;
			}
		}
		if (tag == -1) {
			Arrays.sort(nums);
			StringBuilder s = new StringBuilder();
			for (int x : nums) {
				s.append(x);
			}
			return s.toString();
		} else {
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[i] > nums[tag - 1]) {
					int temp = nums[i];
					nums[i] = nums[tag - 1];
					nums[tag - 1] = temp;
					break;
				}
			}
			Arrays.sort(nums, tag, nums.length);
			StringBuilder s = new StringBuilder();
			for (int x : nums) {
				s.append(x);
			}
			return s.toString();
		}
	}

	public String getPermutation(int n, int k) {
		String s = "";
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
			s += (nums[i] + "");
		}
		for (int i = 0; i < k; i++) {
			s = nextPermutation(nums);
		}
		return s;
	}
}
