package algorithm;

public class StringMultiply {
	public String add(String a, String b) {
		int l = Math.max(a.length(), b.length());
		int m = -1;
		if (l == a.length()) {
			m = b.length();
			for (int i = 0; i < l - m; i++) {
				b = "0" + b;
			}
		} else {
			m = a.length();
			for (int i = 0; i < l - m; i++) {
				a = "0" + a;
			}
		}
		int c = 0;
		String s = "";
		for (int i = l - 1; i >= 0; i--) {
			int x = a.charAt(i) - '0';
			int y = b.charAt(i) - '0';
			int r = (x + y + c) % 10;
			s = r + s;
			c = (x + y + c) / 10;
		}
		if (c != 0)
			s = c + s;
		return s;
	}

	public String multiply1(String a, String b) {
		int c = 0;
		int m = Integer.parseInt(b);
		String re = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			int g = a.charAt(i) - '0';
			re = (g * m + c) % 10 + re;
			c = (g * m + c) / 10;
		}
		if (c != 0)
			re = c + re;
		return re;
	}

	public String multiply(String num1, String num2) {
		int l = Math.max(num1.length(), num2.length());
		int m = -1;
		String longer = "";
		String shorter = "";
		if (l == num1.length()) {
			longer = num1;
			shorter = num2;
			m = num2.length();
		} else {
			longer = num2;
			shorter = num1;
			m = num1.length();
		}
		String re = "0";
		for (int j = m - 1; j >= 0; j--) {
			String s = multiply1(longer, shorter.charAt(j) + "");
			for (int x = 0; x < m - j - 1; x++) {
				s = s + "0";
			}
			re = add(re, s);
		}
		int tag = -1;
		for (int i = 0; i < re.length(); i++) {
			if (re.charAt(i) - '0' != 0) {
				tag = i;
				break;
			}
		}
		if (tag == -1)
			return "0";
		else {
			return re.substring(tag, re.length());
		}
	}

	public static void main(String[] args) {
		StringMultiply t = new StringMultiply();
		String d = t.add("999999999999999", "0");
		d = t.multiply("9889", "10");
		System.out.println(d);
	}
}
