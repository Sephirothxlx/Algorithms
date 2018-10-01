package algorithm.dynamicprogramming;

public class LC91DecodeWays {
	int x = 0;

	// public void recursion(String s){
	// if(s.length()==0)
	// x++;
	// else
	// for(int i=0;i<s.length();i++){
	// if(i>=2)
	// break;
	// String temp=s.substring(0,i+1);
	// if(temp.charAt(0)=='0')
	// break;
	// int n=Integer.parseInt(temp);
	// if(n<=26&&n>=1)
	// recursion(s.substring(i+1,s.length()));
	// else
	// break;
	// }
	// }
	//
	// public int numDecodings(String s) {
	// if(s.length()==0)
	// return 0;
	// recursion(s);
	// return x;
	// }
	
	/*
	 * need to use a array to store the values
	 */
	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		int[] m = new int[s.length()];
		int temp = s.charAt(0) - '0';
		if (temp <= 9 && temp >= 1) {
			m[0] = 1;
		} else
			return 0;

		for (int i = 1; i < s.length(); i++) {
			int d = s.charAt(i) - '0';
			if (d != 0) {
				int g = Integer.parseInt(s.substring(i - 1, i + 1));
				if (g <= 26 && g >= 10) {
					if (i == 1)
						m[i] = 2;
					else
						m[i] = m[i - 1] + m[i - 2];
				} else {
					m[i] = m[i - 1];
				}
			} else {
				int g = Integer.parseInt(s.substring(i - 1, i + 1));
				if (g <= 26 && g >= 10) {
					if (i == 1)
						m[i] = 1;
					else
						m[i] = m[i - 2];
				} else {
					return 0;
				}
			}
		}
		return m[s.length() - 1];
	}
}
