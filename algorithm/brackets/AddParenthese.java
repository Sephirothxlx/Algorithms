package algorithm.brackets;

import java.util.ArrayList;
import java.util.List;

public class AddParenthese {
	
	// solution0: generated String by rules
	// keep the track
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		addParenthese(res, "", 0, 0, 2 * n);
		return res;
	}

	public void addParenthese(List<String> res, String s, int open, int closed, int max) {
		if (s.length() == max) {
			res.add(s);
			return;
		}
		if (open < max / 2)
			addParenthese(res, s + "(", open + 1, closed, max);

		if (closed < open)
			addParenthese(res, s + ")", open, closed + 1, max);
	}
}
