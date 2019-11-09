package algorithm.expedia;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OA3 {
	public int bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		Set<Integer> set=new HashSet<>();
		q.add(start);
		q.add(0);
		set.add(start);
		while(!q.isEmpty()) {
			int temp=q.poll();
			if(temp==0)
				break;
			int step=q.poll();
			//right most
			if(!set.contains(temp^1)) {
				q.add(temp^1);
				q.add(step+1);
				set.add(temp^1);
			}
			String s=Integer.toBinaryString(temp);
			for(int i=s.length()-1;i>=0;i--) {
				if(s.charAt(i)=='1') {
					if(i-1>=0) {
						s=s.substring(0,i-1)+(s.charAt(i-1)=='0'?'1':'0')+s.substring(i);
						break;
					}
				}
			}
			if(!s.equals(Integer.toBinaryString(temp))) {
				if(!set.contains(Integer.parseInt(s,2))) {
					q.add(Integer.parseInt(s,2));
					q.add(step+1);
					set.add(Integer.parseInt(s,2));
				}
			}
		}
		return q.poll();
	}
	
	public static void main(String[]args) {
		OA3 o=new OA3();
		//System.out.println(8^1);
		System.out.println(o.bfs(9));
	}
}
