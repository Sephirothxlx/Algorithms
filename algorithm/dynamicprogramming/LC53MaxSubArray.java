package algorithm.dynamicprogramming;

public class LC53MaxSubArray {
	public static int max(int[] nums, int i, int j) {
		if (i == j)
			return nums[i];
		int m = (i + j) / 2;
		int x = max(nums, i, m);
		int y = max(nums, m + 1, j);
		int maxR = 0;
		int temp = 0;
		int maxL = 0;
		int temp2 = 0;
		for (int g = m + 1; g < nums.length; g++) {
			temp += nums[g];
			if (temp > maxR)
				maxR = temp;
		}
		for (int g = m - 1; g >= 0; g--) {
			temp2 += nums[g];
			if (temp2 > maxL)
				maxL = temp2;
		}
		int maxM = maxR + maxL + nums[m];
		return Math.max(Math.max(x, y), maxM);
	}

	public static int maxSubArray2(int[] nums) {
		int x = max(nums, 0, nums.length - 1);
		return x;
	}

	public static int maxSubArray(int[] nums) {
		int[] maxSubArray = new int[nums.length];
		int i = Integer.MIN_VALUE;
		int a = 0, b = 0;
		for (int x = 0; x < nums.length; x++) {
			int n = 0;
			if (x == 0)
				n = nums[x];
			else {
				if (maxSubArray[x - 1] + nums[x] > nums[x]) {
					n = maxSubArray[x - 1] + nums[x];
					b = x;
				} else {
					n = nums[x];
					a = x;
					b = x;
				}
			}
			maxSubArray[x] = n;
			if (n > i) {
				i = n;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int[] n = new int[] { 1, -3, 4, -8, -2, 1, 5, -3 };
		System.out.println(maxSubArray(n));
		System.out.println(maxSubArray2(n));
	}
}
