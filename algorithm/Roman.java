package algorithm;

import java.util.HashMap;

public class Roman {
	public int romanToInt(String s) {
		int res = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("I", new Integer(1));
		hm.put("V", new Integer(5));
		hm.put("X", new Integer(10));
		hm.put("L", new Integer(50));
		hm.put("C", new Integer(100));
		hm.put("D", new Integer(500));
		hm.put("M", new Integer(1000));
		int i = 0;
		for (; i < s.length() - 1; i++) {
			if (hm.get(s.charAt(i) + "").intValue() >= hm.get(s.charAt(i + 1) + "").intValue())
				res += hm.get(s.charAt(i) + "").intValue();
			else {
				res -= hm.get(s.charAt(i) + "").intValue();
			}
		}
		res += hm.get(s.charAt(i) + "").intValue();
		return res;
	}

	public String intToRoman(int num) {
		String res = "";
		while (num != 0) {
			if (num >= 1000) {
				num -= 1000;
				res += "M";
			} else if (num >= 900) {
				num -= 900;
				res += "CM";
			} else if (num >= 500) {
				num -= 500;
				res += "D";
			} else if (num >= 400) {
				num -= 400;
				res += "CD";
			} else if (num >= 100) {
				num -= 100;
				res += "C";
			} else if (num >= 90) {
				num -= 90;
				res += "XC";
			} else if (num >= 50) {
				num -= 50;
				res += "L";
			} else if (num >= 40) {
				num -= 40;
				res += "XL";
			} else if (num >= 10) {
				num -= 10;
				res += "X";
			} else if (num >= 9) {
				num -= 9;
				res += "IX";
			} else if (num >= 5) {
				num -= 5;
				res += "V";
			} else if (num >= 4) {
				num -= 4;
				res += "IV";
			} else if (num >= 1) {
				num -= 1;
				res += "I";
			}
		}
		return res;
	}
}
