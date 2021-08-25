def main():
    n = int(input())
    w = [int(word) for word in input().strip().split()]
    a = [int(word) - 1 for word in input().strip().split()]
    s = [0 for i in range(n + 1)]
    right = [i for i in range(n)]
    left = [i for i in range(n)]
    ans = []
    cur = 0
    for i in a[::-1]:
        ans.append(cur)
        s[i] = w[i] + s[i - 1] + s[i + 1]
        l, r = i, i
        if s[i + 1] > 0:
            r = right[i + 1]
        if s[i - 1] > 0:
            l = left[i - 1]
        right[l] = r
        left[r] = l
        s[l] = s[i]
        s[r] = s[i]
        cur = max(cur, s[i])
    for res in ans[::-1]:
        print(res)


if __name__ == "__main__":
    main()
