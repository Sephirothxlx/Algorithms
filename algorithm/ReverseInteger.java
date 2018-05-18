package algorithm;
public class ReverseInteger {
	public int reverse(int x) {
		long res=0;
		String s=Integer.toString(x);
		if(s.charAt(0)=='-') {
			String n=new StringBuffer(s.substring(1, s.length())).reverse().toString();
			res=0-Long.parseLong(n);
		}else {
			String n=new StringBuffer(s.substring(0, s.length())).reverse().toString();
			res=Long.parseLong(n);
		}
		if(res!=(int)res)
			return 0;
		return (int)res;
	}
	
	public int reverse2(int x) {
		long res=0;
		while(x!=0) {
			res=res*10+x%10;
			x=x/10;
			if(res!=(int)res)
				return 0;
		}
		return (int)res;
	}
	
	public static void main(String[]args) {
		ReverseInteger ri=new ReverseInteger();
		System.out.println(ri.reverse2(1534236469));
	}
}
