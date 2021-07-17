package hashtable;

import java.util.HashMap;
import java.util.Map;

class $1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{hashmap.get(target - nums[i]), i};
            }
            hashmap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }
}
