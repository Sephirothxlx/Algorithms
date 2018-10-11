package algorithm.dynamicprogramming;

import java.util.HashMap;

public class LC560SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		int sum=0;
		int count=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			h.put(sum, h.getOrDefault(sum, 1));
			if(h.containsKey(sum-k))
				count+=h.get(sum-k);
		}
		return count;
	}
}
