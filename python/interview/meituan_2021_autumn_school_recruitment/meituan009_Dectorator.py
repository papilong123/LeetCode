def main():
    n, m = list(map(int, input().strip().split()))
    MOD = 998244353
    memo = [[0] * (m + 1) for _ in range(n + 1)]

    def dfs(start, pre, n, m, memo):
        if start == m:
            return 1
        if memo[pre][start] != 0:
            return memo[pre][start]
        fi = pre if start > 0 else 1
        res = 0
        for i in range(fi, n + 1, fi):
            res = (res + dfs(start + 1, i, n, m, memo)) % MOD
        memo[pre][start] = res
        return res

    res = dfs(0, 0, n, m, memo)
    print(res)


if __name__ == '__main__':
    main()
