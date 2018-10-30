package algorithm;

public class LC10 {
	public boolean isMatch(String s, String p) {
		if (s.length() == 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}

		if (p.length() == 0) {
			if (s.length() == 0)
				return true;
			else
				return false;
		}

		if (!p.contains("*") && !p.contains(".")) {
			if (s.equals(p))
				return true;
			else
				return false;
		}

		boolean[][] m = new boolean[s.length()][p.length()];

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (i == 0 && j == 0)
					m[i][j] = true;
				if (i == 0 && j != 0) {
					if (m[i][j - 1] && p.charAt(j) == '*')
						m[i][j] = true;
					else
						m[i][j] = false;
				} else if (i != 0 && j == 0) {
					m[i][j] = false;
				} else {
					if(m[i-1][j-1]){
						if(p.charAt(j)=='*'){
							if(p.charAt(j-1)=='*')
								m[i][j]=false;
							else if(p.charAt(j-1)=='.')
								m[i][j]=true;
							else if(p.charAt(j-1)==s.charAt(i))
								m[i][j]=true;
							else
								m[i][j]=false;
						}else if(p.charAt(j)=='.'){
							m[i][j]=true;
						}else{
							if(p.charAt(j)==s.charAt(i))
								m[i][j]=true;
							else{
								m[i][j]=false;
							}
						}
					}else{
						m[i][j]=false;
					}
				}
			}
		}

		return m[s.length() - 1][p.length() - 1];
	}
}
