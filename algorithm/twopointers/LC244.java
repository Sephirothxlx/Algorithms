package algorithm.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC244 {
	HashMap<String,List<Integer>> map;
	public LC244(String[] words) {
		map=new HashMap<>();
		for(int i=0;i<words.length;i++) {
			if(!map.containsKey(words[i])) {
				map.put(words[i],new ArrayList<>());
			}
			map.get(words[i]).add(i);
		}
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1=map.get(word1);
        List<Integer> l2=map.get(word2);
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        while(i<l1.size()&&j<l2.size()) {
        	min=Math.min(min, Math.abs(l1.get(i)-l2.get(j)));
        	if(l1.get(i)<l2.get(j)) {
        		i++;
        	}else {
        		j++;
        	}
        }
        return min;
    }
}
