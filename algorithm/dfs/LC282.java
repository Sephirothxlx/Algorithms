package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC282 {
	public List<String> addOperators(String num, int target) {
		List<String> l = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return l;
		helper(l, "", target, num, 0, 0, 0);
		return l;
	}

	public void helper(List<String> l, String s, int target, String num, int pos, long eval, long mul) {
		if (pos == num.length()) {
			if (target == eval)
				l.add(s);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(l, s + cur, target, num, i + 1, cur, cur);
			} else {
				helper(l, s + "+" + cur, target, num, i + 1, eval + cur, cur);
				helper(l, s + "-" + cur, target, num, i + 1, eval - cur, -cur);
				helper(l, s + "*" + cur, target, num, i + 1, eval - mul + mul * cur, mul * cur);
			}
		}
	}
}
