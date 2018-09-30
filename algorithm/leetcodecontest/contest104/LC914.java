package algorithm.leetcodecontest.contest104;

import java.util.HashMap;

public class LC914 {
	public int gcd(int a, int b) {
		if (a < b)
			return a;
		if (a == b)
			return 0;
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public boolean hasGroupsSizeX(int[] deck) {
		if (deck.length == 0)
			return true;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < deck.length; i++) {
			if (!h.containsKey(deck[i]))
				h.put(deck[i], 1);
			else
				h.put(deck[i], h.get(deck[i]) + 1);
		}
		int small = Integer.MAX_VALUE;
		for (int x : h.keySet()) {
			if (h.get(x) < small) {
				small = h.get(x);
			}
		}
		for (int x : h.keySet()) {
			if (gcd(h.get(x).intValue(), small) < 2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LC914 l = new LC914();
		System.out.println(l.gcd(3, 3));
	}
}
