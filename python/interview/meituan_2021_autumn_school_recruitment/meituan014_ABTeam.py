def main():
    x, y = map(int, input().split())
    nums = list(map(int, input().split()))
    cntX, cntY = x, y

    sort = sorted(range(x + y), key=nums.__getitem__, reverse=True)
    if y > x:
        ans = ['B'] * (x + y)
        for i in range(x):
            ans[sort[i]] = 'A'
    elif y == x:
        ans = ['A'] * x + ['B'] * y
    else:
        ans = ['B'] * (x + y)
        for i in range(x):
            ans[sort[~i]] = 'A'

    print(''.join(ans))


if __name__ == '__main__':
    main()
