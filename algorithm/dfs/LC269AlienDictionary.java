package algorithm.dfs;

public class LC269AlienDictionary {
	public String alienOrder(String[] words) {
		int[]letter=new int[26];
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				letter[words[i].charAt(j)-'a']=1;
			}
		}
		
		String re="";
		return re;
	}
}	
