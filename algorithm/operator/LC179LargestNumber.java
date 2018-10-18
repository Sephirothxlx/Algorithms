package algorithm.operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LC179LargestNumber {
	public String largestNumber(int[] nums) {

		if (nums == null || nums.length == 0)
			return "";

		ArrayList<String> al = new ArrayList<>();
		for (int x : nums)
			al.add(Integer.toString(x)); // converting to string

		Comparator<String> byVal = new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		};
		Collections.sort(al, byVal);

		if (al.get(0).charAt(0) == '0')
			return "0";// edge case when your array has bunch of zeros

		return String.join("", al);

	}
}
