package algorithm.google;

import java.util.Arrays;

public class Test3 {
	public int find(int[] stores, int k) {
		int i = 0;
		int j = stores.length - 1;
		while (i < j) {
			if (j - i == 1) 
				break;
			int mid = (i + j) / 2;
			if (stores[mid] == k)
				return stores[mid];
			else if (stores[mid] < k) {
				i = mid;
			} else {
				j = mid;
			}
		}
		if(i==0)
		int a = k - stores[i];
		int b = stores[j] - k;
		if (a <= b)
			return stores[i];
		else
			return stores[j];
	}

	public int[] solution(int[] stores, int[] houses) {
		// write your code in Java SE 8
		Arrays.sort(stores);
		int[] re = new int[houses.length];
		for (int i = 0; i < re.length; i++) {
			re[i] = find(stores, houses[i]);
		}
		return re;
	}
}
