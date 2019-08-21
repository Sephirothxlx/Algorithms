package algorithm.databricks;

import java.util.Stack;

public class LC42TrappingRainWater {
    public int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int n=height.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int max=height[0];
        for(int i=1;i<height.length;i++){
            left[i]=max;
            max=Math.max(max,height[i]);
        }
        max=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=max;
            max=Math.max(max,height[i]);
        }
        int res=0;
        for(int i=1;i<n-1;i++){
            int temp=Math.min(left[i],right[i]);
            if(temp>height[i]){
                res+=temp-height[i];
            }
        }
        return res;
    }

    public int trap2(int []height){
        if(height==null||height.length==0)
            return 0;
        int n=height.length;
        Stack<Integer> s=new Stack<>();
        int res=0,cur=0;
        while(cur<n){
            while(!s.isEmpty()&&height[cur]>height[s.peek()]){
                int i=s.pop();
                if(s.isEmpty())
                    break;
                int dist=cur-s.peek()-1;
                res+=dist*(Math.min(height[cur],height[s.peek()])-height[i]);
            }
            s.push(cur++);
        }
        return res;
    }
    public int trap3(int []height){
        if(height==null||height.length==0)
            return 0;
        int n=height.length;
        int left=0,right=n-1;
        int res=0,left_max=0,right_max=0;
        while(left<right){
            if(height[left]<height[right]){
                if(left_max<=height[left]){
                    left_max=height[left];
                }else{
                    res+=left_max-height[left];
                }
                left++;
            }else{
                if(right_max<=height[right]){
                    right_max=height[right];
                }else{
                    res+=right_max-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
