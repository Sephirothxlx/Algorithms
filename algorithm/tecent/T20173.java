package algorithm.tecent;

import java.util.Arrays;
import java.util.Scanner;

public class T20173 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int i = in.nextInt();
			int[] n = new int[i];
			for (int j = 0; j < i; j++) {
				n[j] = in.nextInt();
			}
			Arrays.sort(n);
			int x = 0, y = 0;
			for (int j = 0; j < i; j++) {
				if (n[0] == n[j])
					x++;
				else
					break;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (n[i - 1] == n[j])
					y++;
				else
					break;
			}
			int l = 0, m = 0;
			if (x != 0 && y != 0) {
				m = x * y;
				l = Math.min(x * (x - 1) / 2, y * (y - 1) / 2);
				if (l == 0) {
					int small = Integer.MAX_VALUE;
					for (int j = 0; j < i - 1; j++) {
						if (small > n[j + 1] - n[j])
							small = n[j + 1] - n[j];
					}
					for (int j = 0; j < i - 1; j++) {
						if (small == n[j + 1] - n[j])
							l++;
					}
				}
			} else if (x == i) {
				m = x * (x - 1) / 2;
				l = x * (x - 1) / 2;
			} else if (y == i) {
				m = y * (y - 1) / 2;
				l = y * (y - 1) / 2;
			}
			System.out.println(l + " " + m);
		}
	}
}
