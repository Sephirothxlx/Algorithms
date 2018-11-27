package algorithm.bitoperation;

public class Multiply {
	public static int add(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}

	public static int multiply(int a, int b) {
		int x = a < 0 ? add(~a, 1) : a;
		int y = b < 0 ? add(~b, 1) : b;
		int res = 0;
		while (x > 0) {
			if ((x & 1) != 0) {
				res = add(y, res);
			}
			x = x >> 1;
			y=y<<1;
		}
		if((a^b)<0)
			return add(~res,1); 
		return res;
	}
	public static void main(String[]args){
		System.out.println(multiply(-101,9));
	}
}
