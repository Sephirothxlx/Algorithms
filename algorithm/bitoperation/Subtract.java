package algorithm.bitoperation;

public class Subtract {
	public static int add(int a,int b){
		if(b==0)
			return a;
		int sum=a^b;
		int carry=(a&b)<<1;
		return add(sum,carry);
	}
	public static int subtract(int a,int b){
		return add(a,add(~b,1));
	}
	
	public static void main(String[]args){
		System.out.println(subtract(-101,-9));
	}
}
