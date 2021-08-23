package cn.leetcode.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class $5853_FindArrayGivenSubsetSums {
    // java实现看不懂可以看python的
    public int[] recoverArray(int n, int[] sums) {

        List<Integer> sums2 = new ArrayList<>();
        for (int i : sums) {
            sums2.add(i);
        }
        Collections.sort(sums2);

        List<Integer> result = new ArrayList<>();
        dfs(n, result, sums2);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int n, List<Integer> result, List<Integer> sums) {
        if (n == 0) {
            return true;
        }
        // num 为最值和次值之差的绝对值（最大值-次大值或最小值-次小值都可以）
        int num = Math.abs(sums.get(0) - sums.get(1));
        // num 或 -num 必然存在于 result 中
        // 以 num 可以将 sums 分成两部分：包含 num 的和不包含 num 的
        // 比如样例 [-3,-2,-1,0,0,1,2,3]
        // num = 1
        // 可以分成 [-3, -1, 0, 2] 和 [-2, 0, 1, 3] 这两部分
        // 若假设 1 存在于 result 中，则以 [-3, -1, 0, 2] 继续递归
        // 若假设 -1 存在于 result 中，则以 [-2, 0, 1, 3] 继续递归
        List<Integer> next = new ArrayList<>();
        LinkedList<Integer> toRemove = new LinkedList<>();

        for (int i : sums) {
            if (toRemove.isEmpty() || toRemove.getFirst() != i) {
                next.add(i);
                toRemove.addLast(i + num);
            } else {
                toRemove.pollFirst();
            }
        }

        // 假定 num 存在于 result 中
        if (sums.contains(num) && dfs(n - 1, result, next)) {
            result.add(num);
            return true;
        }

        // 假定 -num 存在于 result 中
        for (int i = 0; i < next.size(); i++) {
            next.set(i, next.get(i) + num);
        }
        if (sums.contains(-num) && dfs(n - 1, result, next)) {
            result.add(-num);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int n = 3;
        int[] res = new $5853_FindArrayGivenSubsetSums().recoverArray(n, nums);
        System.out.println();
    }
}
