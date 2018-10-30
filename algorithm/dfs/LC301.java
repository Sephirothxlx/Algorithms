package algorithm.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301 {
	public List<String> removeInvalidParentheses(String s) {
		if (s == null)
			return new ArrayList<String>();
		int lc = 0, rc = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				lc++;
			} else if (s.charAt(i) == ')') {
				if (lc != 0)
					lc--;
				else
					rc++;
			}
		}
		Set<String> res = new HashSet<String>();
		dfs(s, 0, lc, rc, res, new StringBuilder(), 0);
		return new ArrayList<String>(res);
	}

	public void dfs(String s, int i, int lc, int rc, Set<String> l, StringBuilder ss, int tag) {
		if (lc < 0 || rc < 0 || tag < 0)
			return;
		if (i == s.length()) {
			if (lc == 0 && rc == 0 && tag == 0)
				l.add(ss.toString());
		} else {
			char c = s.charAt(i);
			int len = ss.length();
			if (c == '(') {
				dfs(s, i + 1, lc - 1, rc, l, ss, tag);
				dfs(s, i + 1, lc, rc, l, ss.append(c), tag + 1);
			} else if (c == ')') {
				dfs(s, i + 1, lc, rc - 1, l, ss, tag);
				dfs(s, i + 1, lc, rc, l, ss.append(c), tag - 1);
			} else {
				dfs(s, i + 1, lc, rc, l, ss.append(c), tag);
			}
			ss.setLength(len);
		}
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
