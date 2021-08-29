package cn.leetcode.binaryindexedtree;

import java.util.*;

// https://www.cnblogs.com/xenny/p/9739600.html
public class $315_CountOfSmallerNumbersAfterSelf {
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        discretization(nums);  // 离散化nums成为a
        init(nums.length + 5);  // 初始化长度为nums.length+5的全零数组
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);  // 从a中找到 值的索引+1
            resultList.add(query(id - 1));
            update(id);  // 对应索引位置数量加1
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

}
