package algorithm.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> h = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			if (h.containsKey(s)) {
				h.get(s).add(strs[i]);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				h.put(s, temp);
			}
		}
		List<List<String>> re = new ArrayList<List<String>>();
		h.forEach((a, b) -> re.add(b));
		return re;
	}
}
