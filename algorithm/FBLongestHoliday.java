package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class FBLongestHoliday {
	public static int getH(boolean[] b, int d) {
		int[] days = new int[b.length];
		Queue<Integer> al = new LinkedList<Integer>();
		int max = 0;
		for (int i = 0; i < b.length; i++) {
			if (i == 0) {
				if (b[0])
					days[0] = 1;
				else {
					if (d - 1 >= 0) {
						days[0] = 1;
						d--;
						al.add(i);
					} else
						days[0] = 0;
				}
			} else {
				if (b[i])
					days[i] = days[i - 1]+1;
				else {
					if (d - 1 >= 0) {
						days[i] = days[i - 1] + 1;
						d--;
						al.add(i);
					} else {
						if (al.isEmpty()) {
							days[i] = 0;
						} else {
							days[i] = days[i - 1] + 1 - days[al.poll()];
						}
					}
				}
			}
			max = Math.max(max, days[i]);
		}
		return max;
	}
	
	public static int getH2(boolean[] b, int d){
		int max=0;
		
		return max;
	}
	
	public static void main(String[]args){
		boolean[]b=new boolean[]{true,false,true,false,true,false,false,false,true,true,false};
		System.out.println(getH(b,2));
	}
}
