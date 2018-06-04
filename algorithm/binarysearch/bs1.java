package algorithm.binarysearch;

public class bs1 {
	// return the start and end of this target in this array
	public int[] searchRange(int[] nums, int target) {
        int []res=new int[2];
        int l=0;
        int r=nums.length-1;
        int mid =0;
        while(l<=r){
            mid = (l+r)/2;
            if(target == nums[mid]){
                int x=mid-1;
                int y=mid+1;
                while(y<=nums.length-1){
                    if(nums[y]==target)
                        y++;
                    else
                        break;                    
                }
                res[1]=y-1;
                while(x>=0){
                    if(nums[x]==target)
                        x--;
                    else
                        break;
                }
                res[0]=x+1;
                return res;
            }
            if(target<nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        res[0]=-1;
        res[1]=-1;
        return res;
    }
}
