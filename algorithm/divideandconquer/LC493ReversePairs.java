package algorithm.divideandconquer;

public class LC493ReversePairs {
	public int merge(int[] nums, int i, int mid, int j) {
		int p = i, q = mid + 1, x = 0, count = 0;
		int a = i, b = mid + 1;
		while (a <= mid && b <= j) {
			while (a <= mid && nums[a] <= 2 * (long) nums[b]) {
				a++;
			}
			if (a == mid + 1)
				break;
			else
				count += (mid - a + 1);
			b++;
		}
		int[] B = new int[j - i + 1];
		while (p <= mid || q <= j) {
			if (p > mid) {
				B[x] = nums[q];
				x++;
				q++;
			} else if (q > j) {
				B[x] = nums[p];
				x++;
				p++;
			} else if (nums[p] > nums[q]) {
				B[x] = nums[q];
				x++;
				q++;
			} else {
				B[x] = nums[p];
				x++;
				p++;
			}
		}
		int h = 0;
		for (int g = i; g <= j; g++) {
			nums[g] = B[h];
			h++;
		}
		return count;
	}

	public int count(int[] nums, int i, int j) {
		if (i >= j)
			return 0;
		int mid = (i + j) / 2;
		int a = count(nums, i, mid);
		int b = count(nums, mid + 1, j);
		int c = merge(nums, i, mid, j);
		return a + b + c;
	}

	public int reversePairs(int[] nums) {
		return count(nums, 0, nums.length - 1);
	}
}
