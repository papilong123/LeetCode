def binary_search(i, j, nums, target):
    while i <= j:
        mid = (i + j) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            i = mid + 1
        else:
            j = mid - 1
    return -1


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    res = binary_search(0, len(arr)-1, arr, 3)
    print(res)
