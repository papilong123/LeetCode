package cn.example.backtrack;

import java.util.*;

public class $40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        if(length == 0) {
            return res;
        }

        // 先排序去重
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(length);
        dfs(candidates, length, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int length, int begin, int target, Deque<Integer> path, List<List<Integer>> res){
        // 符合要求加入结果集
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < length; i++){
            // 大剪枝
            if(target - candidates[i] < 0){
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }

            path.addLast(candidates[i]);

            dfs(candidates, length, i+1, target - candidates[i], path, res);

            path.removeLast();
        }
    }

    // https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
    // 解释语句: if cur > begin and candidates[cur-1] == candidates[cur] 是如何避免重复的。
    // 这个避免重复当思想是在是太重要了。
    // 这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
    //                 1
    //                 / \
    //                 2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
    //             /     \
    //             5       5
    //                 例2
    //                 1
    //                 /
    //                 2      这种情况确是允许的
    //             /
    //             2

    // 为何会有这种神奇的效果呢？
    // 首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
    // 可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
    // 因为当第二个2出现的时候，他就和前一个2相同了。

    // 那么如何保留例2呢？
    // 那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
    // 例2的两个2是处在不同层级上的。
    // 在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
    // 必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
    // 第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
}
