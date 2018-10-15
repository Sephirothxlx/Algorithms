package algorithm.tecent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Tecent3 {
	static List<int[]> l = new ArrayList<int[]>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = in.nextInt();
			}
			permutate(m, 0);
			Set<Integer> s = new HashSet<Integer>(100000);
			for (int[] k : l) {
				for (int i = 1; i < k.length; i++) {
					int sum = 0;
					for (int j = 0; j < i; j++) {
						sum += k[j];
					}
					s.add(sum);
				}
			}
			int re = 1;
			while (true) {
				if (!s.contains(re)) {
					System.out.println(re);
					break;
				} else
					re++;
			}
		}
	}

	public static void permutate(int[] m, int i) {
		if (i == m.length - 1) {
			int temp[] = new int[m.length];
			System.arraycopy(m, 0, temp, 0, m.length);
			l.add(temp);
		} else {
			for (int j = i; j < m.length; j++) {
				swap(m, i, j);
				permutate(m, i + 1);
				swap(m, i, j);
			}
		}
	}

	public static void swap(int[] m, int i, int j) {
		int temp = m[i];
		m[i] = m[j];
		m[j] = temp;
	}
}
