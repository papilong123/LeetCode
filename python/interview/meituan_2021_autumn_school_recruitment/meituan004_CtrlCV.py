n = int(input())

B = [-1] * n
A = list(map(int, input().split()))

m = int(input())
for _ in range(m):
    s = list(map(int, input().split()))
    if s[0] == 1:
        _, k, x, y = s
        B[y - 1: y - 1 + k] = A[x - 1: x - 1 + k]
    else:  # == 2
        i = s[1] - 1
        print(B[i])
