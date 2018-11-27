package algorithm.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestConstructor {
	public static class t {
		t(int t) {
		};
	}

	public class h {
		h(int h) {
		};
	}

	public static void main(String[] args) {
		TestConstructor tt = new TestConstructor();
		t g = new TestConstructor.t(1);
		h gg = tt.new h(1);
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		h.put(1, 1);
		HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>(h);
	    for(int x:h1.keySet()){
	    	System.out.println(x);
	    }
	    int []a=new int[]{1,2,3,4,5};
	    String ss[]=new String[]{"1","2","3"};
	    Arrays.sort(ss,Collections.reverseOrder());
	    SortedMap<Integer,Integer> s=new TreeMap<Integer,Integer>(new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
	    	
	    });
	    
	}
}
