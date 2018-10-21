package algorithm.google;

public class Test1 {
	public String solution(String S, int K) {
        // write your code in Java SE 8
        String temp=S.toUpperCase();
        String temp1=temp.replace("-", "");
        int head=temp1.length()%K;
        int x=temp1.length()/K;
        String re=temp1.substring(0, head);
        while(x>0){
        	re+="-";
        	re+=temp1.substring(head,head+K);
        	head=head+K;
        	x--;
        }
        if(temp1.length()%K==0)
        	return re.substring(1, re.length());
        else 
        	return re;
    }
	
	public static void main(String[]args){
		Test1 t=new Test1();
		System.out.println(t.solution("r", 1));
	}
}
