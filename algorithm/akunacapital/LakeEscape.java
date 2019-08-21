package algorithm.akunacapital;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class A{
	private int i;
	public int j;
	static int c;
	public static final int d=1;
}

class C implements Runnable{
	public void run() {
		
	}
}

public class LakeEscape extends Thread{
	Lock l=new ReentrantLock();
	class B{
		
	}
	HashMap map;
	public void test() {
		Thread t=new Thread(new C());
		t.start();
		B b=new LakeEscape().new B();
		l.lock();
		synchronized(this){
			
		}
		l.unlock();
	}
	
	public void run() {
		
	}
}
