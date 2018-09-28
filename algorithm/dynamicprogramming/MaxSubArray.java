package algorithm.dynamicprogramming;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int []maxSubArray=new int[nums.length];
		int i = Integer.MIN_VALUE;
		for (int x = 0; x < nums.length; x++) {
			int n=0;
			if (x == 0)
				n=nums[x];
			else {
				n=Math.max(maxSubArray[x-1] + nums[x], nums[x]);
			}
			maxSubArray[x]=n;
			if (n > i) {
				i = n;
			}
		}
		return i;
	}
}
