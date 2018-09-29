package algorithm.permutation;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int tag = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] <= nums[i - 1]) {
				continue;
			} else {
				tag = i;
				break;
			}
		}
		if (tag == -1)
			Arrays.sort(nums);
		else {
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[i] > nums[tag - 1]) {
					int temp = nums[i];
					nums[i] = nums[tag - 1];
					nums[tag - 1] = temp;
					break;
				}
			}
			Arrays.sort(nums, tag, nums.length);
		}
	}
}
