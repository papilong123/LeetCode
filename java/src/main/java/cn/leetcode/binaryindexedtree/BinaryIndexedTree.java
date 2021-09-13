package cn.leetcode.binaryindexedtree;

// 树状数组模板
// 时间复杂度：add 操作和 query 的复杂度都是 O(logn)，因此构建数组的复杂度为 O(nlogn)。整体复杂度为 O(nlogn)
// 空间复杂度：O(n)
public class BinaryIndexedTree {
    int[] tree;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }

    int[] nums;
    int n;

    public BinaryIndexedTree(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }

}
