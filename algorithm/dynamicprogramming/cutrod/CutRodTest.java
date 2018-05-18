package algorithm.dynamicprogramming.cutrod;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CutRodTest {
	private int[] price=new int[]{0,1,5,8,9,10,17,17,20,24,30};
	private int[]rightAnswers=new int[] {0,1,5,8,10,13,17,18,22,25,30};
	private int []actual=new int[11];
	private int[] rightCut=new int[] {0,1,2,3,2,2,6,1,2,3,10};
	private CutRod cr= new CutRod();
	@Test
	public void test0() {
		for(int i=0;i<=10;i++) {
			actual[i]=cr.cutRodByRecursion(price, i);
		}
		assertArrayEquals(rightAnswers, actual);
	}
	@Test
	public void test1() {
		//this memory array records the most price of index length
		int []memory=new int[11];
		for(int i=0;i<=10;i++) {
			actual[i]=cr.cutRodByDP0(price, i,memory);
		}
		assertArrayEquals(rightAnswers, actual);
	}
	@Test
	public void test2() {
		for(int i=0;i<=10;i++) {
			actual[i]=cr.cutRodByDP1(price, i);
		}
		assertArrayEquals(rightAnswers, actual);
	}
	@Test
	public void test3() {
		int []cut=new int[11];
		for(int i=0;i<=10;i++) {
			actual[i]=cr.cutRodByDP2(price, i,cut);
		}
		assertArrayEquals(rightAnswers, actual);
		assertArrayEquals(rightCut, cut);
	}
}
