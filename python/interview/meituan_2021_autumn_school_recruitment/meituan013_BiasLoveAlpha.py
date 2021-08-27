n = int(input().strip())
s = input().strip()

res = 0
k = 0
for i in s:
    k += 1 if i == 'E' else -1
    k = max(0, k)
    res = max(res, k)
print(res)
