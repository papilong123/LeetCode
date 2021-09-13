## 涉及数组的修改

1. 数组不变，求区间和：「前缀和」、「树状数组」、「线段树」

2. 多次修改某个数，求区间和：「树状数组」、「线段树」

3. 多次整体修改某个区间，求区间和：「线段树」、「树状数组」（看修改区间的数据范围）

4. 多次将某个区间变成同一个数，求区间和：「线段树」、「树状数组」（看修改区间的数据范围）

这样看来，「线段树」能解决的问题是最多的，那我们是不是无论什么情况都写「线段树」呢？

答案并不是，而且恰好相反，只有在我们遇到第 4 类问题，不得不写「线段树」的时候，我们才考虑线段树。

因为「线段树」代码很长，而且常数很大，实际表现不算很好。我们只有在不得不用的时候才考虑「线段树」。

总结一下，我们应该按这样的优先级进行考虑：

简单求区间和，用「前缀和」 多次将某个区间变成同一个数，用「线段树」 其他情况，用「树状数组」

## 加粗字体为最佳方案

数组不变，区间查询：**前缀和**、树状数组、线段树；  
数组单点修改，区间查询：**树状数组**、线段树；  
数组区间修改，单点查询：**差分**、线段树；  
数组区间修改，区间查询：**线段树**。  