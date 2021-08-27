a, b, c, d, e, f, g = list(map(int, input().strip().split()))

clothes = [a, b, c, d]
price = [(e, 0, 3), (f, 1, 3), (g, 2, 3)]
price.sort(key=lambda k: -k[0])

res = 0
for pair in price:
    m, idx1, idx2 = pair
    minn = min(clothes[idx1], clothes[idx2])
    res += m * minn
    clothes[idx1] -= minn
    clothes[idx2] -= minn

print(res)
