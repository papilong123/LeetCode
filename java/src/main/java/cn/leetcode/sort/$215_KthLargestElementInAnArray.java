package cn.leetcode.sort;

import java.util.Random;

public class $215_KthLargestElementInAnArray {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        }
        int ansIndex = quickSelsct(nums, 0, n - 1, n - k);  //第n大的数刚好在n-k索引位置上
        return nums[ansIndex];
    }

    public int quickSelsct(int[] nums, int i, int j, int k) {
        int partition = randomPartition(nums, i, j);
        if (partition == k) {
            return partition;
        } else if (partition < k) {
            return quickSelsct(nums, partition + 1, j, k);
        } else {
            return quickSelsct(nums, i, partition - 1, k);
        }
    }

    private int randomPartition(int[] nums, int i, int j) {
        int index = i + random.nextInt(j - i + 1);
        swap(nums, index, i);
        return partition(nums, i, j);
    }

    private int partition(int[] nums, int i, int j) {
        int key = i;
        while (i < j) {
            while (i < j && nums[key] <= nums[j]) {
                j--;
            }
            while (i < j && nums[key] >= nums[i]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, key, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 堆排序
    public int findKthLargestHeap(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }


    public static void main(String[] args) {
        int ans = new $215_KthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(ans);
    }
}
