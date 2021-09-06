package cn.leetcode.binaryindexedtree;

class $327_CountOfRangeSum {
    // 前缀和+归并排序
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {  // 求前缀和
            s += nums[i];
            preSum[i + 1] = s;
        }
        return countRangeSumRecursive(preSum, lower, upper, 0, preSum.length - 1);
    }

    public int countRangeSumRecursive(long[] preSum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(preSum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(preSum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && preSum[l] - preSum[i] < lower) {
                    l++;
                }
                while (r <= right && preSum[r] - preSum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = preSum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = preSum[p1++];
                } else {
                    if (preSum[p1] < preSum[p2]) {
                        sorted[p++] = preSum[p1++];
                    } else {
                        sorted[p++] = preSum[p2++];
                    }
                }
            }
            System.arraycopy(sorted, 0, preSum, left, sorted.length);

            return ret;
        }
    }
}
