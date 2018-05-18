package algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int l=0,r=0;
        int n=Integer.MIN_VALUE,m=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            l=i+1;
            r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    if(n!=nums[l]||m!=nums[r]){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(new Integer(nums[i]));
                        temp.add(new Integer(nums[l]));
                        temp.add(new Integer(nums[r]));
                        res.add(temp);
                        n=nums[l];
                        m=nums[r];
                    }
                    l++;
                    r--;
                }else{
                    if(sum<0){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    
    }
	
	public static void main(String[]args) {
		TripleSum t=new TripleSum();
		System.out.println(Arrays.toString(t.threeSum(new int[] {-2,0,0,2,2}).toArray()));
		
	}
}
