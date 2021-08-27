arr = []


def check(left, right, n):
    global arr
    pre = -1
    for i in range(n):
        x = arr[i]
        if (left > x) or (right < x):
            if x < pre: return False
            pre = x
    return True


def main():
    global arr
    m, n = map(int, input().split())
    arr = [i for i in map(int, input().split())]
    res = 0
    for i in range(1, m + 1):
        left = i
        right = m + 1
        while left < right:
            mid = ((right - left) >> 1) + left
            if check(i, mid, n):
                right = mid
            else:
                left = mid + 1
        res += (m - left + 1)
        if left == n + 1: break
    print(f"{res}\n")
    return 0


if __name__ == "__main__":
    main()
