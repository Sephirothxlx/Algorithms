package algorithm.operator;

public class Divide {
	//the most stupid way 
	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		int res = 0;
		if (dividend == -2147483648) {
			if (divisor < 0) {
				//put the judgment at the top of loop
				while (dividend <= divisor) {
					dividend -= divisor;
					res++;
					if (res == 2147483647)
						return res;
				}
			} else {
				while ((dividend + divisor) <= 0) {
					dividend += divisor;
					res--;
				}
			}
			return res;
		}
		int tag = 1;
		res = 0;
		if (dividend > 0 && divisor > 0) {
			tag = 0;
		}
		if (dividend < 0 && divisor < 0) {
			tag = 0;
		}
		int m = dividend, n = divisor;
		if (m < 0)
			m = -m;
		if (n < 0)
			n = -n;

		while (m >= n) {
			m -= n;
			res++;
		}
		if (tag == 1)
			res = -res;
		return res;
	}
}
