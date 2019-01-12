package algorithm.jianzhioffer.string;

/**
 * @author Sephiroth
 *实现正则表达式中.和*的功能。.表示任意一个字符，*表示他前面的字符的任意次（含0次）。
 *比如aaa与a.a和ab*ac*a匹配，但与aa.a和ab*a不匹配。
 *
 *使用动态规划解决问题
 */
public class Q19 {
	public static boolean match(String s, String p){
		boolean dp[][]=new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*')
			    dp[0][i]=dp[0][i-2];
		}
		for(int i=1;i<=s.length();i++){
			for(int j=1;j<=p.length();j++){
				char a=s.charAt(i-1);
				char b=p.charAt(j-1);
				if(a==b||b=='.'){
					dp[i][j]=dp[i-1][j-1];
				}else if(b=='*'){
					//in this case, * can only means zero because the former character mismatch
                    if(a!=p.charAt(j-2)&&p.charAt(j-2)!='.')
                        dp[i][j]=dp[i][j-2];
                    else
					    dp[i][j]=dp[i][j-2]||dp[i][j-1]||dp[i-1][j];
				}
			}
		}
        return dp[s.length()][p.length()];
	}
	
	public static void main(String []args){
		System.out.println(match("abccccaa",".bc*a*"));
	}
}
