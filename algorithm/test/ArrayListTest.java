package algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
	public static void main(String[]args){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);
		ArrayList<Integer> b=new ArrayList<Integer>(a);
		System.out.println(Arrays.toString(b.toArray()));
	}
}
