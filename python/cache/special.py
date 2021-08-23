# 二维数组求和的几种方法
from functools import reduce

a = [[1, 2], [3, 4], [5, 6]]
sum(map(sum, a))
sum(sum(i) for i in a)
sum(sum(a[i]) for i in range(len(a)))
reduce(lambda x, y: x + y, reduce(lambda x, y: x + y, a))

# 解释一下reduce(fun,a),reduce返回的是一个结果值而不是一个list，第一步的时候是（［1，2］＋［3，4］） ＋ ［5，6］
# 得到一个［1，2，3，4，5，6］， 然后进行的运算是（（（（（1+2）＋3）＋4）＋5）＋6） ＝ 21
# 一般来说最常用的还是1和3这两种方法，不知道map or reduce, 一般都会采用3， 而知道的应该会采用1，比较简洁。
