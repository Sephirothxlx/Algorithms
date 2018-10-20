package algorithm.dynamicprogramming;

import java.util.List;

public class LC120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;
		int total = Integer.MAX_VALUE;
		int n = triangle.size();
		int[] least = new int[n * (n + 1) / 2];
		least[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			least[i * (i + 1) / 2] = least[i * (i - 1) / 2]+triangle.get(i).get(0);
			least[i * (i + 1) / 2 + triangle.get(i).size() - 1] = least[i * (i - 1) / 2 + triangle.get(i - 1).size()
					- 1]+triangle.get(i).get(triangle.get(i).size()-1);
			for (int j = 1; j < triangle.get(i).size() - 1; j++) {
				least[i * (i + 1) / 2 + j] = Math.min(least[i * (i - 1) / 2 + j - 1], least[i * (i - 1) / 2 + j])
						+ triangle.get(i).get(j);
			}
		}
		for (int i = n * (n - 1) / 2; i < least.length; i++) {
			if (total > least[i])
				total = least[i];
		}
		return total;
	}
}
