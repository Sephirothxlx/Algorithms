package algorithm.leetcodecontest.contest104;

public class LC915 {
	public int partitionDisjoint(int[] A) {
		int big = A[0];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > big)
				big = A[i];
			int tag = 0;
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < big) {
					tag = 1;
					break;
				}
			}
			if (tag == 1)
				continue;
			else
				return i + 1;
		}
		return -1;
	}
}
