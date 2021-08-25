def main():
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(list(map(int, input().strip().split())))

    used = [0] * (n + 1)
    for i in range(n):
        for j in range(n):
            pos = mat[i][j]
            if used[pos] == 0:
                used[pos] = i + 1
                print(pos, end=" ")
                break


if __name__ == '__main__':
    main()
