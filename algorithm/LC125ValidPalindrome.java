package algorithm;

public class LC125ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[_^\\w]", "");
        String ss = s.toLowerCase();
	    StringBuilder sss = new StringBuilder(ss);
	    String ssss = sss.reverse().toString();
	    return ss.equals(ssss);
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
