package algorithm.tree;

public class LC96UBSTNum {
	public int numTrees(int n) {
		if (n == 0)
			return 0;
		int[] g = new int[n + 1];
		g[0] = 1;
		g[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				g[i] = g[i] + (g[j] * g[i - j - 1]);
			}
		}
		return g[n];
	}
}
