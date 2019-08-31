package algorithm.databricks;

public class LC91DecodeWays {
	public int numDecodings(String s) {
		//base case
		if(s==null||s.length()==0)
        	return 0;
        int[]dp=new int[s.length()+1];
        //base case
        dp[0]=1;
        //base case
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++) {
        	char a=s.charAt(i-2);
        	char b=s.charAt(i-1);
        	if(b!='0') {
        		dp[i]+=dp[i-1];
        	}
        	if(a=='1'||(a=='2'&&b-'0'<=6)) {
        		dp[i]+=dp[i-2];
        	}
        }
        return dp[s.length()];
    }
}
