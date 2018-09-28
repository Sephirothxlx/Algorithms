package algorithm.recursion;

public class CanJump {
	// public boolean canJump(int[] nums, int start) {
	// if (start == nums.length - 1) {
	// return true;
	// } else {
	// int x = nums[start];
	// for (int i = 1; i <= x; i++) {
	// if (i + start < nums.length) {
	// if (canJump(nums, i + start) == true) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	// }
	//
	// public boolean canJump(int[] nums) {
	// return canJump(nums, 0);
	// }

	// public boolean canJump(int[] nums) {
	// int[] segment = new int[nums.length - 1];
	// for (int i = 0; i < nums.length; i++) {
	// int x = nums[i];
	// for (int j = i; j < i + x; j++) {
	// if (j < segment.length)
	// segment[j] = 1;
	// }
	// }
	// for (int i = 0; i < segment.length; i++) {
	// if (segment[i] == 0)
	// return false;
	// }
	// return true;
	// }
	public boolean canJump(int[] nums) {
		int maxJump = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxJump < i) {
				return false;
			}
			if (maxJump == nums.length - 1)
				break;
			maxJump = Math.max(maxJump, i + nums[i]);
		}
		return true;
	}
}
