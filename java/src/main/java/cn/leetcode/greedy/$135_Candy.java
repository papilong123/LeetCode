package cn.leetcode.greedy;

public class $135_Candy {
    public int candy(int[] ratings) {
        int ans = 0, n = ratings.length;

        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {

            } else {

            }
        }

        return ans;
    }
}
