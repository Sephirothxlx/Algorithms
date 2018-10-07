package algorithm.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class LC218TheSkylineProblem {
	public List<int[]> skyline(int[][] b, int i, int j) {
		if (b.length == 0)
			return new ArrayList<int[]>();
		if (i == j) {
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[] { b[i][0], b[i][2] });
			l.add(new int[] { b[i][1], 0 });
			return l;
		}
		int mid = (i + j) / 2;
		List<int[]> left = skyline(b, i, mid);
		List<int[]> right = skyline(b, mid + 1, j);
		return merge(left, right);
	}

	public List<int[]> merge(List<int[]> left, List<int[]> right) {
		int i = 0, j = 0, skyL = 0, skyR = 0, maxSky = 0;
		List<int[]> l = new ArrayList<int[]>();
		while (i < left.size() || j < right.size()) {
			if (i >= left.size()) {
				l.add(right.get(j));
				j++;
			} else if (j >= right.size()) {
				l.add(left.get(i));
				i++;
			} else if (left.get(i)[0] < right.get(j)[0]) {
				skyL = left.get(i)[1];
				if (maxSky != Math.max(skyL, skyR)) {
					maxSky = Math.max(skyL, skyR);
					l.add(new int[] { left.get(i)[0], maxSky });
				}
				i++;
			} else if (left.get(i)[0] > right.get(j)[0]) {
				skyR = right.get(j)[1];
				if (maxSky != Math.max(skyL, skyR)) {
					maxSky = Math.max(skyL, skyR);
					l.add(new int[] { right.get(j)[0], maxSky });
				}
				j++;
			} else {
				skyL = left.get(i)[1];
				skyR = right.get(j)[1];
				if (maxSky != Math.max(skyL, skyR)) {
					maxSky = Math.max(skyL, skyR);
					l.add(new int[] { right.get(j)[0], maxSky });
				}
				i++;
				j++;
			}
		}
		return l;
	}

	public List<int[]> getSkyline(int[][] buildings) {
		return skyline(buildings, 0, buildings.length - 1);
	}
}
