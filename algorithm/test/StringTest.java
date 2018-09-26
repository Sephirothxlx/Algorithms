package algorithm.test;

import java.util.Arrays;

public class StringTest {
	public static void main(String[] args) {
		String s = "rtsdf";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String d = new String(c);
		System.out.println(d);
	}
}
