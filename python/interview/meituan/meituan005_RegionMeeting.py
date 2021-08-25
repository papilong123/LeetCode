def main():
    n, k = list(map(int, input().strip().split()))
    graph = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        i, j = list(map(int, input().strip().split()))
        graph[i].append(j)
        graph[j].append(i)
    a = [0] + list(map(int, input().strip().split()))
    mod = 10 ** 9 + 7

    def dfs(u, fa):
        nonlocal graph, a, k, mod, i
        res = 1
        for v in graph[u]:
            # 不能指向父节点和比父节点小的元素，范围不能比最初的父节点小
            if v != fa and (a[i] < a[v] or (a[i] == a[v] and i < v)) and a[i] + k >= a[v]:
                res *= (dfs(v, u) + 1)
                res %= mod
        return res

    ans = 0
    for i in range(1, n + 1):
        ans += dfs(i, 0)
        ans %= mod
    print(ans)


if __name__ == "__main__":
    main()
