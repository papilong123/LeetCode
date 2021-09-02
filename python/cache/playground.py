import bisect


def f():
    nums = [1, 2, 2, 4, 4, 5]
    idx1 = bisect.bisect_left(nums, 2)
    idx2 = bisect.bisect_left(nums, 3)
    idx3 = bisect.bisect_right(nums, 2)
    idx4 = bisect.bisect_right(nums, 3)
    print()


if __name__ == '__main__':
    f()
