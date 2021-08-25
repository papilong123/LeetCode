n = int(input())
lines = []
for i in range(n):
    line = input()
    lines.append(line)

res = []
for line in lines:
    flag = True

    if not line[0].isalpha():
        flag = False

    k, t = 0, 0
    for i in range(len(line)):
        if line[i].isalpha():
            k += 1
        if line[i].isdigit():
            t += 1
    if k == 0 or t == 0:
        flag = False

    cnt = 0
    for i in range(len(line)):
        if line[i].isalpha() or line[i].isdigit():
            cnt += 1

    if cnt != len(line):
        flag = False

    if flag:
        res.append("Accept")
    else:
        res.append("Wrong")
for re in res:
    print(re)
