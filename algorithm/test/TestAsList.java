package algorithm.test;

import java.util.Arrays;
import java.util.List;

public class TestAsList {
	public static void main(String[] args) {
		char[] c = new char[] { 's' };
		List l = Arrays.asList(new Character[] { 's' });
		String fd = "sss";
		System.out.println(Arrays.toString(l.toArray()));
	}
}
