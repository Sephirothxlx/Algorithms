package algorithm.databricks;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(word==null||word.length()==0)
			return true;
        if(board==null||board.length==0||board[0].length==0)
        	return false;
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(dfs(board,i,j,word))
        			return true;
        	}
        }
        return false;
    }
	
	public boolean dfs(char[][]board,int i,int j, String word) {
		if(board[i][j]=='1')
			return false;
		if(word.length()==1) {
			if(word.charAt(0)==board[i][j])
				return true;
			else
				return false;
		}
		if(word.charAt(0)!=board[i][j])
			return false;
		char c=board[i][j];
		board[i][j]='1';
		String s=word.substring(1);
		if(i-1>=0) {
			if(dfs(board,i-1,j,s))
				return true;
		}
		if(i+1<board.length) {
			if(dfs(board,i+1,j,s))
				return true;
		}
		if(j-1>=0) {
			if(dfs(board,i,j-1,s))
				return true;
		}
		if(j+1<board[0].length) {
			if(dfs(board,i,j+1,s))
				return true;
		}
		board[i][j]=c;
		return false;
	}
}
