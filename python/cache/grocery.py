import heapq

n = int(input())
weight = [0] + list(map(int, input().split()))
order = [0] + list(map(int, input().split()))

group = [(-sum(weight), 1, n, weight)]
heapq.heapify(group)
for i in range(1, n + 1):
    for g in group:
        if g[1] <= order[i] <= g[2]:

    left_sum = sum(weight[:order[i]])
    right_sum = sum(weight[order[i] + 1:])
    bigger = max(left_sum, right_sum)
    print(bigger)
    weight[order[i]] = 0
