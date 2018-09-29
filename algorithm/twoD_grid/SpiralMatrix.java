package algorithm.twoD_grid;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new ArrayList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int i = 0, j = 0;
		int l = matrix[0].length;
		int h = matrix.length;
		int ll = -1;
		int hh = 0;
		int x = l * h;
		int n = 0;
		while (true) {
			al.add(matrix[i][j]);
			x--;
			if (x == 0)
				break;
			if (n == 0) {
				j++;
				if (j == l) {
					l--;
					j--;
					i++;
					n = 1;
				}
			} else if (n == 1) {
				i++;
				if (i == h) {
					h--;
					i--;
					j--;
					n = 2;
				}
			} else if (n == 2) {
				j--;
				if (j == ll) {
					ll++;
					j++;
					i--;
					n = 3;
				}
			} else {
				i--;
				if (i == hh) {
					hh++;
					i++;
					j++;
					n = 0;
				}
			}
		}
		return al;
	}
}
