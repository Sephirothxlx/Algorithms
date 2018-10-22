package algorithm.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
	public int longestConsecutive(int[] nums) {
		if(nums.length==0)
            return 0;
		Set<Integer> s = new HashSet<Integer>();
		for (int x : nums) {
			s.add(x);
		}
		int big = 1;
		for (int x : nums) {
			int c = 1;
			Set<Integer> temp = new HashSet<Integer>(s);
			for (int i = x + 1;; i++) {
				if (s.contains(i)) {
					c++;
					temp.remove(i);
				} else
					break;
			}
			for (int i = x - 1;; i--) {
				if (s.contains(i)) {
					c++;
					temp.remove(i);
				} else
					break;
			}
			if (c > big)
				big = c;
		}
		return big;
	}
}
