package algorithm.expedia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OA4 {
	public String shortest(String s) {
		Set<Character> set=new HashSet<>();
		for(char c:s.toCharArray()) {
			set.add(c);
		}
		Map<Character,Integer> map=new HashMap<>();
		for(char c:set) {
			map.put(c,0);
		}
		int start=0,end=0;
		int size=0;
		int min=Integer.MAX_VALUE;
		String minS="";
		while(end<s.length()) {
			char temp=s.charAt(end);
			map.put(temp,map.get(temp)+1);
			if(map.get(temp)==1)
				size++;
			end++;
			while(size==set.size()) {
				if(size==set.size()) {
					if(end-start<min) {
						minS=s.substring(start,end);
						min=end-start;
					}
				}
				temp=s.charAt(start++);
				map.put(temp, map.get(temp)-1);
				if(map.get(temp)==0)
					size--;
			}
		}
		return minS;
	}
	
	public static void main(String[]args) {
		OA4 o=new OA4();
		System.out.println(o.shortest("dabbcabcd"));
	}
}
