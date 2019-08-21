package databricks;

public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 1;
        boolean tag=false;
        for(int i=0;i<n;i++){
            if(nums[i]==1)
                tag=true;
            if(nums[i]<=0||nums[i]>n)
                nums[i]=1;
        }
        if(!tag)
            return 1;
        for(int i=0;i<n;i++){
            int a=(int)Math.abs(nums[i]);
            if(a==n)
                nums[0]=-(int)Math.abs(nums[0]);
            else
                nums[a]=-(int)Math.abs(nums[a]);
        }
        for(int i=1;i<n;i++){
            if(nums[i]>0)
                return i;
        }
        if(nums[0]>0)
            return n;
        return n+1;
    }
}
