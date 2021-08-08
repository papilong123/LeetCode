package cn.leetcode.binarysearch;

import java.util.Arrays;

public class $611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
//        排序
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
//                找到最后一个满足条件的k值
                int left = j, right = n - 1, k = j;
                while(left <= right){
                    int mid = (left + right)/2;
                    if(nums[i] + nums[j] > nums[mid]){
                        k = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                res += k - j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int ans = new $611_ValidTriangleNumber().triangleNumber(new int[]{3,1,2,3,3,3,3});
        System.out.println();
    }
}
