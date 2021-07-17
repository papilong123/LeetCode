package Array;

class Solution {
    public int trap(int[] height) {
        int start=0,end=height.length-1,sum=0,maxleft=0,maxright=0;
        while(start<end){
            if(height[start]<height[end]){
                if(height[start]>=maxleft){
                    maxleft=height[start];
                    }else{
                        sum+=(maxleft-height[start]);
                }
                start++;
            }else{
                if(height[end]>=maxright){
                    maxright=height[end];
                    }else{
                    sum+=(maxright-height[end]);
                    }
                end--;
            }
        }
        return sum;
    }
}
