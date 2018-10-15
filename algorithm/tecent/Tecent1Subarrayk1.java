package algorithm.tecent;

import java.util.HashMap;
import java.util.Scanner;

public class Tecent1Subarrayk1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {// 注意while处理多个case
			int k = in.nextInt();
			in.nextLine();
			String s = in.nextLine();
			HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
			h.put(0, 1);
			int sum = 0;
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1')
					sum += 1;
				if (h.containsKey(sum - k))
					count += h.get(sum - k);
				if (h.containsKey(sum))
					h.put(sum, h.get(sum) + 1);
				else
					h.put(sum, 1);
			}
			System.out.println(count);
		}
	}
}
