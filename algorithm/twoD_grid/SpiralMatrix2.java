package algorithm.twoD_grid;

import java.util.ArrayList;

public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		if (n == 0)
			return new int[0][0];
		int[][] matrix = new int[n][n];
		int i = 0, j = 0;
		int l = n;
		int h = n;
		int ll = -1;
		int hh = 0;
		int x = 1;
		int f = 0;
		while (true) {
			matrix[i][j] = x;
			x++;
			if (x == n * n + 1)
				break;
			if (f == 0) {
				j++;
				if (j == l) {
					l--;
					j--;
					i++;
					f = 1;
				}
			} else if (f == 1) {
				i++;
				if (i == h) {
					h--;
					i--;
					j--;
					f = 2;
				}
			} else if (f == 2) {
				j--;
				if (j == ll) {
					ll++;
					j++;
					i--;
					f = 3;
				}
			} else {
				i--;
				if (i == hh) {
					hh++;
					i++;
					j++;
					f = 0;
				}
			}
		}
		return matrix;
	}
}
