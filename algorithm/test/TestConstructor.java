package algorithm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	}
}
