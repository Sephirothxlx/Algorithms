package algorithm.leetcodecontest.contest105;

import java.util.Arrays;

public class LC918MaximumSumCircularSubarray {
	public static int maxSubarraySumCircular(int[] A) {
		int[] C = new int[A.length + A.length - 1];
		int x = 0;
		for (int i = 1; i < A.length; i++) {
			C[x++] = A[i];
		}
		System.arraycopy(A, 0, C, x, A.length);
		System.out.println(Arrays.toString(C));
		int n[] = new int[C.length];
		int max = Integer.MIN_VALUE;
		int s = 0, e = 0;
		n[0] = C[0];
		for (int i = 1; i < n.length; i++) {
			if (n[i - 1] <= 0) {
				n[i] = C[i];
				s = i;
			} else {
				if (i - s >= A.length) {
					int temp = Integer.MIN_VALUE;
					int temp2 = 0;
					int temp3=s;
					for (int j = i; j > temp3; j--) {
						temp2 += C[j];
						if (temp2 > temp) {
							temp = temp2;
							s = j;
						}
					}
					n[i] = temp;
					e=i;
				} else
					n[i] = n[i - 1] + C[i];

			}
			if (max < n[i]) {
				max = n[i];
				e = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubarraySumCircular(new int[] { 6,9,-3 }));
	}
}
