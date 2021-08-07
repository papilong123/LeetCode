package cn.example.fastslowpointers;

public class $457_CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) { // 如果已经访问过则跳过
                continue;
            }
            int slow = i, fast = next(nums, i); // 快慢指针起点不同
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
//            方向相同的一路设置为0
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }

    public static void main(String[] args) {
        boolean ans = new $457_CircularArrayLoop().circularArrayLoop(new int[]{-1,2});
        System.out.println(ans);
    }

}
