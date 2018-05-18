package algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int li=Integer.MIN_VALUE;
        int lj=Integer.MIN_VALUE;
        int lastJ=Integer.MIN_VALUE;
        int lastL=Integer.MIN_VALUE;
        int lastR=Integer.MIN_VALUE;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==li)
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==li&&nums[j]==lj)
                    continue;
                li=nums[i];
                lj=nums[j];
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        if(nums[j]!=lastJ||nums[l]!=lastL||nums[r]!=lastR){
                            List<Integer> temp=new ArrayList<Integer>();
                            temp.add(new Integer(nums[i]));
                            temp.add(new Integer(nums[j]));
                            temp.add(new Integer(nums[l]));
                            temp.add(new Integer(nums[r]));
                            res.add(temp);
                            lastJ=nums[j];
                            lastL=nums[l];
                            lastR=nums[r];
                        }
                        l++;
                        r--;
                    }else{
                        if(sum<target)
                            l++;
                        else
                            r--;
                    }
                }
            }
        }
        return res;
    }
	
	public static void main(String[]args) {
		FourSum fs=new FourSum();
		System.out.println(Arrays.toString(fs.fourSum(new int[] {-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5}, 28).toArray()));
	}
}
