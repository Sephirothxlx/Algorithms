package algorithm;

public class Atoi {
	public int myAtoi(String str) {
		str=str.trim();
        String s="";
        long res=0;
        int isNeg=0,i=0;
        if(str.length()==0||!((str.charAt(0)=='-'||str.charAt(0)=='+')||(str.charAt(0)-'0'<10&&str.charAt(0)-'0'>=0)))
            return 0;
        if(str.charAt(0)=='-'){
            isNeg=1;
            i=1;
        }
        if(str.charAt(0)=='+'){
            i=1;
        }
        for(;i<str.length();i++){
            if(str.charAt(i)-'0'>10||str.charAt(i)-'0'<0)
                break;
            s+=str.charAt(i);
        }
        for(i=0;i<s.length();i++){
            res+=(s.charAt(i)-'0')*Math.pow(10,s.length()-1-i);
            if(res!=(int)res) {
            	if(isNeg==1)
            		return Integer.MIN_VALUE;
                else
            	    return Integer.MAX_VALUE;
            }
        }
        if(isNeg==1)
            res=0-res;
        return (int)res;
    }
	public static void main(String[]args) {
		Atoi a=new Atoi();
		System.out.println(a.myAtoi("   -1212"));
	}
}
