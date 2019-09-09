package algorithm.databricks;

import java.util.*;

public class LC218SkyLine {
	public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res=skyline(buildings,0,buildings.length-1);
        return res;
    }
	
	public List<List<Integer>> skyline(int[][]buildings,int i,int j){
		if(buildings.length==0)
			return new ArrayList<>();
		if(i==j) {
			List<List<Integer>> list=new ArrayList<>();
			List<Integer> l1=new ArrayList<>();
			List<Integer> l2=new ArrayList<>();
			l1.add(buildings[i][0]);
			l1.add(buildings[i][2]);
			list.add(l1);
			l2.add(buildings[i][1]);
			l2.add(0);
			list.add(l2);
			return list;
		}
		int mid=i+(j-i)/2;
		List<List<Integer>> l1=skyline(buildings,i,mid);
		List<List<Integer>> l2=skyline(buildings,mid+1,j);
		return merge(l1,l2);
	}
	
	public List<List<Integer>> merge(List<List<Integer>> l1,List<List<Integer>>l2){
		List<List<Integer>> list=new ArrayList<>();
		int i=0,j=0,skyL=0,skyR=0,maxSky=0;
		while(i<l1.size()||j<l2.size()) {
			if(i>=l1.size()) {
				list.add(l2.get(j));
				j++;
			}else if(j>=l2.size()) {
				list.add(l1.get(i));
				i++;
			}else if(l1.get(i).get(0)>l2.get(j).get(0)) {
				skyL=l1.get(i).get(1);
				if(maxSky!=Math.max(skyL, skyR)) {
					maxSky=Math.max(skyL, skyR);
					List<Integer> l=new ArrayList<>();
                    l.add(l1.get(i).get(0));
                    l.add(maxSky);
                    list.add(l);
				}
				i++;
			}else if(l1.get(i).get(0)<l2.get(j).get(0)) {
				skyR=l2.get(j).get(1);
                if(maxSky!=Math.max(skyL,skyR)){
                    maxSky=Math.max(skyL,skyR);
                    List<Integer> l=new ArrayList<>();
                    l.add(l2.get(j).get(0));
                    l.add(maxSky);
                    list.add(l);
                }
                j++;
			}else {
				skyL=l1.get(i).get(1);
                skyR=l2.get(j).get(1);
                if(maxSky!=Math.max(skyL,skyR)){
                    maxSky=Math.max(skyL,skyR);
                    List<Integer> l=new ArrayList<>();
                    l.add(l1.get(i).get(0));
                    l.add(maxSky);
                    list.add(l);
                }
                i++;
                j++;
			}
		}
		return list;
	}
}
