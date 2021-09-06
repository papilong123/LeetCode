import bisect


def binary_search_equal(nums, target, left, right):
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1


def binary_search_right(nums, target, left=0, right=None):
    if left < 0:
        raise ValueError('left must be non-negative')
    if right is None:
        right = len(nums)
    while left < right:
        mid = (left + right) // 2
        if target < nums[mid]:
            right = mid
        else:
            left = mid + 1
    return left


# 找target的索引下标用bisect_left
def binary_search_left(a, target, left=0, right=None):
    if left < 0:
        raise ValueError('left must be non-negative')
    if right is None:
        right = len(a)
    while left < right:
        mid = (left + right) // 2
        if a[mid] < target:
            left = mid + 1
        else:
            right = mid
    return left


# 标准模板
def binary_search1(nums, target, left=0, right=None):
    if left < 0:
        raise ValueError('left must be non-negative')
    if right is None:
        right = len(nums)
    while left < right:
        mid = (left + right) // 2
        if nums[mid] <= target:
            right = mid
        else:
            left = mid + 1
    return left


def binary_search2(nums, target, left=0, right=None):
    if left < 0:
        raise ValueError('left must be non-negative')
    if right is None:
        right = len(nums)
    while left < right:
        mid = (left + right + 1) // 2
        if nums[mid] >= target:
            left = mid
        else:
            right = mid - 1
    return left


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    res = binary_search_left(arr, 3, 0)
    print(res)
