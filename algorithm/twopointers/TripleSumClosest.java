package algorithm.twopointers;

import java.util.Arrays;

public class TripleSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int res = 0;
		Arrays.sort(nums);
		int l = 0, r = 0;
		double diff = Integer.MAX_VALUE, t = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			l = i + 1;
			r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				t = Math.abs(sum - target);
				if (t < diff) {
					res = sum;
					diff = t;
				}
				if (sum < target) {
					l++;
				} else {
					r--;
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		TripleSumClosest t = new TripleSumClosest();
		System.out.println(t.threeSumClosest(new int[] { 0, 2, 1, -3 }, 1));

	}
}
