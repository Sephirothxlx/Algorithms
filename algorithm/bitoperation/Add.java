package algorithm.bitoperation;

public class Add {
	public static int add(int a,int b){
		if(b==0)
			return a;
		int sum=a^b;
		int carry=(a&b)<<1;
		return add(sum,carry);
	}
	
	public static int add2(int a, int b){
		while(b!=0){
			int temp=a^b;
			b=(a&b)<<1;
			a=temp;
		}
		return a;
	}
	
	public static void main(String[]args){
		System.out.println(add2(-101,9));
	}
}
