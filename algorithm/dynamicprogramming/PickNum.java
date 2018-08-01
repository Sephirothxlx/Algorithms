package algorithm.dynamicprogramming;

public class PickNum {

	public static boolean check(int[] a) {
		boolean res = false;
		int[][] n = new int[a.length][a.length];
		int r = dp(0, a.length - 1, n, a);
		System.out.println(r);
		int sum = 0;
		for (int x : a) {
			sum += x;
		}
		if (r > sum / 2)
			res = true;
		else
			res = false;
		return res;
	}

	public static int dp(int lo, int hi, int[][] n, int[] a) {
		int res = 0;
		if (lo == hi) {
			n[lo][hi] = 0;
			return 0;
		}

		if ((hi - lo + 1) % 2 == 0) {
			res = Math.max(dp(lo + 1, hi, n, a) + a[lo], dp(lo, hi - 1, n, a) + a[hi]);
		} else {
			res = Math.min(dp(lo + 1, hi, n, a), dp(lo, hi - 1, n, a));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(check(new int[] { 9, 5, 10, 55, 1, 6 }));
		int[] a = new int[] { 9, 5, 10, 55, 1, 6 };
		int[][] n = new int[a.length][a.length];
	}
}
