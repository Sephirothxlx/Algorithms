package algorithm.divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC315CountofSmallerNumbersAfterSelf {
	public void merge(int[] nums, int i, int mid, int j, int[] m, int[] c) {
		int p = i, q = mid + 1, x = 0;
		int[] B = new int[j - i + 1];
		int[] C = new int[j - i + 1];
		while (p <= mid || q <= j) {
			if (p > mid) {
				B[x] = nums[q];
				C[x] = m[q];
				x++;
				q++;
			} else if (q > j) {
				B[x] = nums[p];
				C[x] = m[p];
				x++;
				p++;
			} else if (nums[p] > nums[q]) {
				for (int y = p; y <= mid; y++)
					c[m[y]]++;
				B[x] = nums[q];
				C[x] = m[q];
				x++;
				q++;
			} else {
				B[x] = nums[p];
				C[x] = m[p];
				x++;
				p++;
			}
		}
		int h = 0;
		for (int g = i; g <= j; g++) {
			nums[g] = B[h];
			m[g] = C[h];
			h++;
		}
	}

	public void count(int[] nums, int i, int j, int[] m, int[] c) {
		if (i >= j)
			return;
		int mid = (i + j) / 2;
		count(nums, i, mid, m, c);
		count(nums, mid + 1, j, m, c);
		merge(nums, i, mid, j, m, c);
	}

	public List<Integer> countSmaller(int[] nums) {
		int[] n = new int[nums.length];
		int[] c = new int[nums.length];
		for (int i = 0; i < n.length; i++) {
			n[i] = i;
		}
		List<int[]> m = new ArrayList<int[]>();
		List<Integer> l = new ArrayList<Integer>();
		count(nums, 0, nums.length - 1, n, c);
		for (int i = 0; i < n.length; i++) {
			l.add(c[i]);
		}
		return l;
	}

	public static void main(String[] args) {
		LC315CountofSmallerNumbersAfterSelf l = new LC315CountofSmallerNumbersAfterSelf();
		l.countSmaller(new int[] { 5, 2, 6, 1 });
	}
}
