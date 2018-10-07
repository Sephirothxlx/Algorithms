package algorithm.divideandconquer;

public class LC775GlobalandLocalInversions {
	public int merge(int[] A, int p, int mid, int r) {
		int i = p;
		int j = mid + 1;
		int x = 0;
		int[] B = new int[r - p + 1];
		int count = 0;
		while (i <= mid || j <= r) {
			if (i > mid) {
				B[x++] = A[j++];
			} else if (j > r) {
				B[x++] = A[i++];
			} else if (A[i] > A[j]) {
				count = count + mid - i + 1;
				B[x++] = A[j++];
			} else {
				B[x++] = A[i++];
			}
		}
		int g = p, h = 0;
		while (g <= r) {
			A[g] = B[h++];
			g++;
		}
		return count;
	}

	public int count(int[] A, int p, int r) {
		if (p > r)
			return 0;
		if (p == r)
			return 0;
		int mid = (p + r) / 2;
		int a = count(A, p, mid);
		int b = count(A, mid + 1, r);
		int c = merge(A, p, mid, r);
		return a + b + c;
	}

	public boolean isIdealPermutation(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1])
				count++;
		}
		int count2 = count(A, 0, A.length - 1);
		if (count != count2)
			return false;
		return true;
	}
}
