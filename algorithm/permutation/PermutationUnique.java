package algorithm.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationUnique {
	public void permute1(int[] nums, int s, List<List<Integer>> al) {
		if (s == nums.length - 1) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				l.add(nums[i]);
			}
			al.add(l);
		} else {
			for (int i = s; i < nums.length; i++) {
				int temp = nums[s];
				nums[s] = nums[i];
				nums[i] = temp;
				permute1(nums, s + 1, al);
				temp = nums[s];
				nums[s] = nums[i];
				nums[i] = temp;
			}
		}
	}

	public boolean isSame(List<Integer> a,List<Integer> b){
		for(int i=0;i<a.size();i++){
			if(a.get(i)!=b.get(i)){
				return false;
			}
		}
		return true;
	}
	
	public void removeDublicate(List<List<Integer>> al){
		ArrayList<List<Integer>> r=new ArrayList<List<Integer>>();
		for(int i=0;i<al.size();i++){
			for(int j=i+1;j<al.size();){
				if(isSame(al.get(i),al.get(j))){
					al.remove(j);
				}else
					j++;
			}
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		permute1(nums, 0, al);
		removeDublicate(al);
		return al;
	}
}
