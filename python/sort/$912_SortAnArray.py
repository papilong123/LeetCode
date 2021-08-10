import math


class Solution(object):
    # 冒泡排序
    def bubbleSort(self, nums):
        n = len(nums)
        if n <= 1:
            return nums
        for i in range(n):
            for j in range(n - 1 - i):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]
        return nums

    # 选择排序
    def selectSort(self, nums):
        n = len(nums)
        if n <= 1:
            return nums
        for i in range(0, n - 1):
            minIndex = i
            for j in range(i + 1, n):  # 比较一遍，记录索引不交换
                if nums[j] < nums[minIndex]:
                    minIndex = j
            if minIndex != i:  # 按索引交换
                nums[minIndex], nums[i] = nums[i], nums[minIndex]
        return nums

    # 插入排序
    def insertSort(self, nums):
        n = len(nums)
        if n <= 1:
            return nums
        for i in range(1, n):
            j = i
            target = nums[i]  # 每次循环的一个待插入的数
            while j > 0 and target < nums[j - 1]:  # 比较、后移，给target腾位置
                nums[j] = nums[j - 1]
                j = j - 1
            nums[j] = target  # 把target插到空位
        return nums

    # 堆排序
    def heapSort(self, nums):
        def heapadjust(arr, start, end):  # 将以start为根节点的堆调整为大顶堆
            temp = arr[start]
            child = 2 * start + 1
            while child <= end:
                if child < end and arr[child] < arr[child + 1]:  # 找出左右孩子节点较大的
                    child += 1
                if temp >= arr[child]:  # 判断是否为大顶堆
                    break
                arr[start] = arr[child]  # 子节点上移
                start = child  # 继续向下比较
                child = 2 * child + 1
            arr[start] = temp  # 将原堆顶插入正确位置

        n = len(nums)
        if n <= 1:
            return nums
        # 建立大顶堆
        root = n // 2 - 1  # 最后一个非叶节点（完全二叉树中）
        while root >= 0:
            heapadjust(nums, root, n - 1)
            root -= 1
        # 掐掉堆顶后调整堆
        i = n - 1
        while i >= 0:
            nums[0], nums[i] = nums[i], nums[0]  # 将大顶堆堆顶数放到最后
            heapadjust(nums, 0, i - 1)  # 调整剩余数组成的堆
            i -= 1
        return nums

    # 快速排序
    def quickSort(self, nums):
        def partition(arr, left, right):
            key = left  # 划分参考数索引,默认为第一个数，可优化
            while left < right:
                while left < right and arr[key] <= arr[right]:
                    right -= 1
                while left < right and arr[key] >= arr[left]:
                    left += 1
                arr[left], arr[right] = arr[right], arr[left]
            arr[left], arr[key] = arr[key], arr[left]
            return left

        def quicksort(arr, left, right):  # 递归调用
            if left >= right:
                return
            mid = partition(arr, left, right)
            quicksort(arr, left, mid - 1)
            quicksort(arr, mid + 1, right)

        # 主函数
        n = len(nums)
        if n <= 1:
            return nums
        quicksort(nums, 0, n - 1)
        return nums

    # 希尔排序
    def shellSort(self, nums):
        def shellInsert(arr, d):
            n = len(arr)
            for i in range(d, n):
                j = i - d
                temp = arr[i]  # 记录要出入的数
                while j >= 0 and arr[j] > temp:  # 从后向前，找打比其小的数的位置
                    arr[j + d] = arr[j]  # 向后挪动
                    j -= d
                if j != i - d:
                    arr[j + d] = temp

        n = len(nums)
        if n <= 1:
            return nums
        d = n // 2
        while d >= 1:
            shellInsert(nums, d)
            d = d // 2
        return nums

    # 归并排序
    def mergeSort(self, nums):
        # 合并左右子序列函数
        def merge(arr, left, mid, right):
            temp = []  # 中间数组
            i = left  # 左段子序列起始
            j = mid + 1  # 右段子序列起始
            while i <= mid and j <= right:
                if arr[i] <= arr[j]:
                    temp.append(arr[i])
                    i += 1
                else:
                    temp.append(arr[j])
                    j += 1
            while i <= mid:
                temp.append(arr[i])
                i += 1
            while j <= right:
                temp.append(arr[j])
                j += 1
            for i in range(left, right + 1):  # !注意这里，不能直接arr=temp,他俩大小都不一定一样
                arr[i] = temp[i - left]

        # 递归调用归并排序
        def mSort(arr, left, right):
            if left >= right:
                return
            mid = (left + right) // 2
            mSort(arr, left, mid)
            mSort(arr, mid + 1, right)
            merge(arr, left, mid, right)

        n = len(nums)
        if n <= 1:
            return nums
        mSort(nums, 0, n - 1)
        return nums

    # 计数排序
    def countSort(self, nums):
        n = len(nums)
        num = max(nums)
        count = [0] * (num + 1)
        for i in range(0, n):
            count[nums[i]] += 1
        arr = []
        for i in range(0, num + 1):
            for j in range(0, count[i]):
                arr.append(i)
        return arr

    # 桶排序
    def bucketSort(self, nums):
        # 桶内使用快速排序
        def quickSort(nums):
            def partition(arr, left, right):
                key = left  # 划分参考数索引,默认为第一个数，可优化
                while left < right:
                    while left < right and arr[right] >= arr[key]:
                        right -= 1
                    while left < right and arr[left] <= arr[key]:
                        left += 1
                    (arr[left], arr[right]) = (arr[right], arr[left])
                (arr[left], arr[key]) = (arr[key], arr[left])
                return left

            def quicksort(arr, left, right):  # 递归调用
                if left >= right:
                    return
                mid = partition(arr, left, right)
                quicksort(arr, left, mid - 1)
                quicksort(arr, mid + 1, right)

            # 主函数
            n = len(nums)
            if n <= 1:
                return nums
            quicksort(nums, 0, n - 1)
            return nums

        ######################
        n = len(nums)
        big = max(nums)
        num = big // 10 + 1
        bucket = []
        buckets = [[] for i in range(0, num)]
        for i in nums:
            buckets[i // 10].append(i)  # 划分桶
        for i in buckets:  # 桶内排序
            bucket = quickSort(i)
        arr = []
        for i in buckets:
            if isinstance(i, list):
                for j in i:
                    arr.append(j)
            else:
                arr.append(i)
        for i in range(0, n):
            nums[i] = arr[i]
        return nums

    # 基数排序

    def radixSort(self, nums):
        def getbit(x, i):  # 返回x的第i位（从右向左，个位为0）数值
            y = x // pow(10, i)
            z = y % 10
            return z

        def CountSort(nums):
            n = len(nums)
            num = max(nums)
            count = [0] * (num + 1)
            for i in range(0, n):
                count[nums[i]] += 1
            arr = []
            for i in range(0, num + 1):
                for j in range(0, count[i]):
                    arr.append(i)
            return arr

        Max = max(nums)
        for k in range(0, int(math.log10(Max)) + 1):  # 对k位数排k次,每次按某一位来排
            arr = [[] for i in range(0, 10)]
            for i in nums:  # 将ls（待排数列）中每个数按某一位分类（0-9共10类）存到arr[][]二维数组（列表）中
                arr[getbit(i, k)].append(i)
            for i in range(0, 10):  # 对arr[]中每一类（一个列表）  按计数排序排好
                if len(arr[i]) > 0:
                    arr[i] = CountSort(arr[i])
            j = 9
            n = len(nums)
            for i in range(0, n):  # 顺序输出arr[][]中数到ls中，即按第k位排好
                while len(arr[j]) == 0:
                    j -= 1
                else:
                    nums[n - 1 - i] = arr[j].pop()
        return nums


instance = Solution()
bubble = instance.bubbleSort([1, 5, 2, 63])
quick = instance.quickSort([1, 65, 2, 29, 3, 54, 7])
