def main():
    n, x, y = list(map(int, input().strip().split()))
    graph = [[] for _ in range(n + 1)]
    for i in range(n - 1):
        u, v = list(map(int, input().strip().split()))
        graph[u].append(v)
        graph[v].append(u)

    # 存储着x/y到index需要的步数
    res_x, res_y = [0] * (n + 1), [0] * (n + 1)

    def dfs(res, number, time=1):
        # 最外层dfs算第一步，所以time = 1
        res[number] = time
        for i in graph[number]:
            if res[i] == 0:
                # 以i为起点，继续dfs
                dfs(res, i, time + 1)

    # 以x为起点，dfs，计的步数放在res_x里，对应其index
    dfs(res_x, x)
    dfs(res_y, y)
    print(max(res_x[i] - 1 if res_x[i] > res_y[i] else 0 for i in range(n)))


if __name__ == '__main__':
    main()
