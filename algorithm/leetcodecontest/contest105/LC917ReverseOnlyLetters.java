package algorithm.leetcodecontest.contest105;


public class LC917ReverseOnlyLetters {
	public static String reverseOnlyLetters(String S) {
		String[] ss = S.split("[^a-zA-Z]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ss.length; i++) {
			sb.append(ss[i]);
		}
		String sss = sb.reverse().toString();
		int x=0;
		sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (Character.isAlphabetic(S.charAt(i)))
				sb.append(sss.charAt(x++));
			else
				sb.append(S.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}
}
