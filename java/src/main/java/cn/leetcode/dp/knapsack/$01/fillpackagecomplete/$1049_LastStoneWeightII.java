package cn.leetcode.dp.knapsack.$01.fillpackagecomplete;

import java.util.Arrays;

public class $1049_LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        // 因为提示中给出1 <= stones.length <= 30，1 <= stones[i] <= 1000，所以最大重量就是30 * 1000 。
        // 而我们要求的target其实只是最大重量的一半，所以dp数组开到15000大小就可以了。
        // 当然也可以把石头遍历一遍，计算出石头总重量 然后除2，得到dp数组的大小。
        // 我这里就直接用15000了。
        int[] dp = new int[15001];
        int sum = Arrays.stream(stones).sum();

        // 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
        int target = sum / 2;
        for (int stone : stones) { // 遍历物品
            for (int j = target; j >= stone; j--) { // 遍历背包
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
