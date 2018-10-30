package algorithm.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC301 {
	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<String>();
		if (s == null)
			return ans;
		Set<String> set = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		set.add(s);
		q.add(s);
		boolean found = false;
		while (!q.isEmpty()) {
			String temp = q.poll();
			if (isValid(temp)) {
				ans.add(temp);
				found = true;
			}
			if (found)
				continue;
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) != '(' && temp.charAt(i) != ')')
					continue;
				String temp2 = temp.substring(0, i) + temp.substring(i + 1, temp.length());
				if (!set.contains(temp2)) {
					set.add(temp2);
					q.add(temp2);
				}
			}
		}
		return ans;
	}

	public boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				count++;
			if (s.charAt(i) == ')') {
				count--;
				if (count < 0)
					return false;
			}
		}
		if (count > 0)
			return false;
		return true;
	}
}
