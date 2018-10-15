package algorithm.tecent;

import java.util.Arrays;
import java.util.Scanner;

public class Tecent2LongestCoolSubarray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = in.nextInt();
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int[] temp = new int[j - i + 1];
					System.arraycopy(m, i, temp, 0, j - i + 1);
					if (check(temp)) {
						if (max < j - i + 1)
							max = j - i + 1;
					}
				}
			}
			System.out.println(max);
		}
	}

	public static boolean check(int[] a) {
		int mid = (a.length - 1) / 2 + 1;
		Arrays.sort(a);
		for (int i = 2; i <= a[a.length - 1]; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j]%i == 0)
					count++;
			}
			if (count >= mid)
				return true;
		}
		return false;
	}
}
