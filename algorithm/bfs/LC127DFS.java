package algorithm.bfs;

import java.util.List;

//dfs
public class LC127DFS {
	int length = Integer.MAX_VALUE;

	public void helper(String word, String word2, List<String> wl, int count) {
		for (int i = 0; i < wl.size(); i++) {
			String temp = wl.get(i);
			int j = 0;
			for (int m = 0; m < temp.length(); m++) {
				if (temp.charAt(m) != word.charAt(m))
					j++;
			}
			if (j == 1) {
				if (count == wl.size())
					break;
				if (temp.equals(word2)) {
					if (count+1 < length)
						length = count+1;
                    break;
				} else
					helper(temp, word2, wl, count+1);
			}
		}
	}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        helper(beginWord, endWord, wordList, 1);
		if (length == Integer.MAX_VALUE)
			return 0;
		else
			return length;
    }
}
