package algorithm.google;

import java.util.ArrayList;
import java.util.HashMap;

public class Test2 {
	public int[] solution(int D, int[] A) {
        // write your code in Java SE 8
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		ArrayList<Integer>l=new ArrayList<Integer>();
		for(int i=0;i<A.length;i++){
			h.put(A[i], i);
		}
		int j=-1;
		for(int i=0;i<A.length;i++){
			j=h.get(j);
			l.add(j);
		}
		int[]re=new int[A.length];
		for(int i=0;i<A.length;i++){
			int temp=l.get(i);
			if(i<D){
				re[temp]=-1;
			}else{
				re[temp]=l.get(i-D);
			}
		}
		return re;
    }
}
