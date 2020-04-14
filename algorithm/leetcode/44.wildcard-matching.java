/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public String clean(String p) {
        boolean tag=false;
        String res="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!='*'){
                res+=p.charAt(i);
                if(tag)
                    tag=false;
            }else if(p.charAt(i)=='*'){
                if(!tag){
                    res+=p.charAt(i);
                    tag=true;
                }
            }
        }
        return res;
    }

    public boolean isMatch(String s, String p) {
        p=clean(p);
        boolean dp[][]=new boolean[p.length()+1][s.length()+1];
        for(int i=1;i<p.length()+1;i++){
            char c=p.charAt(i-1);
            if(c=='*'){
                int minMathchId=0;
                for(;minMathchId<s.length()+1;minMathchId++){
                    if(dp[i-1][minMathchId])
                        break;
                }
                for(int k=minMathchId;k<s.length()+1;k++){
                    dp[i][k]=true;
                }
            }else if(c=='?'){
                for(int j=1;j<s.length()+1;j++){
                    dp[i][j]=dp[i-1][j-1];
                }
            }else{
                for(int j=1;j<s.length()+1;j++){
                    if(c!=s.charAt(j-1))
                        dp[i][j]=false;
                    else
                        dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
// @lc code=end

