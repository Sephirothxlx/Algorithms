package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> al = new ArrayList<String>();
		if (digits.length() == 0)
			return al;
		String s = "";
		if (digits.charAt(0) == '2') {
			s = "abc";
		} else if (digits.charAt(0) == '3') {
			s = "def";
		} else if (digits.charAt(0) == '4') {
			s = "ghi";
		} else if (digits.charAt(0) == '5') {
			s = "jkl";
		} else if (digits.charAt(0) == '6') {
			s = "mno";
		} else if (digits.charAt(0) == '7') {
			s = "pqrs";
		} else if (digits.charAt(0) == '8') {
			s = "tuv";
		} else if (digits.charAt(0) == '9') {
			s = "wxyz";
		}
		if (digits.length() == 1) {
			al = new ArrayList<String>();
			for (int j = 0; j < s.length(); j++) {
				al.add(s.charAt(j) + "");
			}
			return al;
		} else {
			for (int j = 0; j < s.length(); j++) {
				List<String> ss = letterCombinations(digits.substring(1, digits.length()));
				for (int k = 0; k < ss.size(); k++) {
					String dd = s.charAt(j) + ss.get(k);
					al.add(dd);
				}
			}
		}
		return al;
	}
	
	public static void main(String[]args) {
		CombinationOfPhoneNumber copn=new CombinationOfPhoneNumber();
		System.out.println(Arrays.toString(copn.letterCombinations("234").toArray()));
	}
}
