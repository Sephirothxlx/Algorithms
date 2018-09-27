package algorithm;

public class FastPow {
	public double myPow(double x, int n) {
		double ans = 1.0;
		double res = x;
		int nn = 0;
		if (n == -2147483648) {
			//if abs will exceed the limit, then deal with the extra one in the last.
			nn = 2147483647;
			while (nn > 0) {
				if (nn % 2 == 1) {
					ans *= res;
				}
				res *= res;
				nn = nn / 2;
			}
			ans *= x;
			return 1.0 / ans;
		} else {
			nn = Math.abs(n);
			while (nn > 0) {
				if (nn % 2 == 1) {
					ans *= res;
				}
				res *= res;
				nn = nn / 2;
			}
			if (n < 0)
				return 1.0 / ans;
			return ans;
		}

	}
}
