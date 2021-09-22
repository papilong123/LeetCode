package cn.leetcode.backtrack.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class $90_SubsetsII {
    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        path.add(nums[cur]);
        dfs(true, cur + 1, nums);
        path.remove(path.size() - 1);
    }
}
