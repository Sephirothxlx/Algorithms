package algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC127BFS {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> q = new LinkedList<String>();
		Queue<Integer> qi = new LinkedList<Integer>();
		Set<String> set = new HashSet<String>();
		q.add(beginWord);
		qi.add(1);
		set.add(beginWord);
		while (!q.isEmpty()) {
			String s = q.poll();
			int c = qi.poll();
			for (int i = 0; i < wordList.size(); i++) {
				String temp = wordList.get(i);
				if (set.contains(temp))
					continue;
				int j = 0;
				for (int m = 0; m < temp.length(); m++) {
					if (temp.charAt(m) != s.charAt(m))
						j++;
				}
				if (j == 1) {
					if (temp.equals(endWord))
						return c + 1;
					q.add(temp);
					qi.add(c + 1);
					set.add(temp);
				}
			}
		}
		return 0;
	}
}
