package cn.example.sort;

import java.util.Arrays;

public class $581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int tmp = nums[0], t;
        for(t = 1; t < nums.length; t++){
            if(tmp > nums[t]){
                break;
            }
            tmp = nums[t];
        }
        if(t == nums.length){
            return 0;
        }

        int[] arrCopy = new int[nums.length];
        System.arraycopy(nums, 0, arrCopy, 0, nums.length);
        Arrays.sort(arrCopy);

        int left = 0;
        while(nums[left] == arrCopy[left]){
            left++;
        }
        int right = nums.length - 1;
        while(nums[right] == arrCopy[right]){
            right--;
        }
        return right - left + 1;
    }
}
