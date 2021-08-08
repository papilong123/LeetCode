package cn.leetcode.array;

import java.util.HashSet;
import java.util.Set;

class $268_MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=0;i<nums.length+1;i++){
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
