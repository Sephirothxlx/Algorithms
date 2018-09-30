package algorithm.leetcodecontest.contest104;

import java.util.ArrayList;
import java.util.List;

public class LC9162 {
	//count char
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> l = new ArrayList<String>();
		int[] count = new int[26];
		for (String s : B) {
			char[] c = s.toCharArray();
			int[] temp = new int[26];
			for (char v : c) {
				temp[v - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (temp[i] > count[i])
					count[i] = temp[i];
			}
		}
		for (String s : A) {
			char[] c = s.toCharArray();
			int[] temp = new int[26];
			for (char v : c) {
				temp[v - 'a']++;
			}
			int t = 0;
			for (int i = 0; i < 26; i++) {
				if (temp[i] < count[i]) {
					t = 1;
					break;
				}
			}
			if (t == 0)
				l.add(s);
		}
		return l;
	}
}
