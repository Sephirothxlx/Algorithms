package algorithm;

public class LC43StringMultiply {
	public String multiply(String num1, String num2) {
		int n = num1.length();
		int m = num2.length();
		int[] pos = new int[n + m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp1 = n - 1 - i;
				int temp2 = m - 1 - j;
				int g = pos[temp1 + temp2+1]+(num1.charAt(temp1) - '0') * (num2.charAt(temp2) - '0');
				pos[temp1 + temp2+1] = g % 10;
				pos[temp1 + temp2] += g / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pos.length; i++) {
			if (sb.length() == 0 && pos[i] == 0)
				continue;
			else
				sb.append(pos[i] + "");
		}
		if (sb.length() == 0)
			return "0";
		else
			return sb.toString();
	}
}
