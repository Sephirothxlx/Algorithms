package algorithm.binarysearch;

public class bs0 {
	// search in rotated sorted array
	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		int mid = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			System.out.println(mid + "" + l + "" + r);
			if (nums[mid] == target)
				return mid;
			if (nums[mid] >= nums[l]) {
				if (nums[mid] >= nums[r]) {
					if (nums[mid] < target) {
						l = mid + 1;
						continue;
					} else {
						if (target >= nums[l]) {
							r = mid - 1;
							continue;
						} else {
							l = mid + 1;
							continue;
						}
					}
				} else {
					if (nums[mid] < target) {
						l = mid + 1;
						continue;
					} else {
						r = mid - 1;
						continue;
					}
				}
			} else {
				if (nums[mid] < target) {
					if (target >= nums[l]) {
						r = mid - 1;
						continue;
					} else {
						l = mid + 1;
						continue;
					}
				} else {
					r = mid - 1;
					continue;
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		bs0 t = new bs0();
		System.out.println(t.search(new int[] { 5, 1, 3 }, 5));
	}
}
