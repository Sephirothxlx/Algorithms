package algorithm.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
	public static class A{
		int a=0;
	} 
	public static void main(String[]args){
		PriorityQueue<A> q=new PriorityQueue<A>(new Comparator<A>(){

			@Override
			public int compare(A o1, A o2) {
				// TODO Auto-generated method stub
				return o1.a-o2.a;
			}
			
		});
		
		A a=new A();
		A b=new A();
		b.a=1;
		A c=new A();
		c.a=2;
		q.add(a);
		q.add(b);
		q.add(c);
		c.a=-1;
		System.out.println(q.poll().a);
	}
}
