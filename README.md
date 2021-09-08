### 滑动窗口
- [$3_无重复字符的最长子串](python/sliding_window/$3_LengthOfLongestSubstring.py)
- [$30_串联所有单词的子串](python/sliding_window/$30_SubstringWithConcatenationOfAllWords.py)
- [$76_最小覆盖子串](python/sliding_window/$76_MinimumWindowSubstring.py)
- [$159_至多包含两个不同字符的最长子串](python/sliding_window/$159_LongestSubstringwithAtMostTwoDistinctCharacters.py)
- [$187_重复的DNA序列](python/sliding_window/$187_RepeatedDNASequences.py)(更适合使用hashmap)
- [$209_长度最小的子数组](python/sliding_window/$209_MinimumSizeSubarraySum.py)
- [$219_存在重复元素II](python/sliding_window/$219_ContainsDuplicateII.py)(窗口长度固定)
- [$220_存在重复元素III](python/sliding_window/$220_ContainsDuplicateIII.py)

### 动态规划

- [$1964_找出到每个位置为止最长的有效障碍赛跑路线](python/dp/$1964_FindTheLongestValidObstacleCourseAtEachPosition.py)
- [$1977_划分数字的方案数](python/dp/$1977_NumberOfWaysToSeparateNumbers.py)
- [$1987_不同的好子序列数目](python/dp/$1987_NumberOfUniqueGoodSubsequences.py)

### dfs

### 二分查找

### 回溯

- [$1723_完成所有工作的最短时间](python/backtrack/$1723_FindMinimumTimeToFinishAllJobs.py)

#### 分治

- [$1982_从子集的和还原数组](python/divide_and_conquer/$1982_FindArrayGivenSubsetSums.py)

### 并查集

- [$1970_你能穿过矩阵的最后一天](python/union_find/$1970_LastDayWhereYouCanStillCross.py)(还可以用二分+bfs解)

### 单调栈

#### 入门

- [$42_接雨水](python/stack/monotone_stack/$42_TrappingRainWater.py)(单减栈)***
- [$84_柱状图中最大的矩形](python/stack/monotone_stack/$84_LargestRectangleInHistogram.py)(单增栈，最后栈内有未处理完的数据，加哨兵或者再出栈一遍)***
- [$85_最大矩形](python/stack/monotone_stack/$85_MaximalRectangle.py)(套用84，对每一行看成直方图)
- [$456_132模式](python/stack/monotone_stack/$456_132Pattern.py)(单减栈，倒序入栈，最小值哨兵，每次出栈记录最大值，只要当前元素小于最大值，就判定为True)***

##### 下一个更大元素

- [$496_下一个更大元素I](python/stack/monotone_stack/$496_NextGreaterElement.py)(单减栈，出栈时用字典记录栈顶元素与比起大的元素的一一对应关系)
- [$503_下一个更大元素II](python/stack/monotone_stack/$496_NextGreaterElementII.py)(套用496，遍历2*n-1个数，遍历时对下标模n)
- [$739_每日温度](python/stack/monotone_stack/$739_DailyTemperatures.py)(简单，出栈时用字典记录下标差值)
- [$1019_链表中的下一个更大节点](python/stack/monotone_stack/$1019_NextGreaterNodeInLinkedList.py)(自己记录下标，将值和下标一起入栈，出栈时记录到列表)
- [$1475_商品折扣后的最终价格](python/stack/monotone_stack/$1475_FinalPricesWithASpecialDiscountInAShop.py)(本质上是下一个更大元素问题)

##### 去除元素后字典序最小

- [$316_去除重复字母](python/stack/monotone_stack/$316_RemoveDuplicateLetters.py)(忽略已经在栈内的元素，比栈顶元素小并且i后面还有剩余的栈顶元素)
- [$321_拼接最大数](python/stack/monotone_stack/$321_CreateMaximumNumber.py)(套用402，分治法分别从两个数组中取i个和k-i个，拼接在一起)
- [$402_移掉K位数字](python/stack/monotone_stack/$402_RemoveKDigits.py)(最多出栈K次)

#### 进阶

- [~~$581_最短无序连续子数组~~](python/stack/monotone_stack/$581_ShortestUnsortedContinuousSubarray.py)(不用看了，不需要用单调栈解)
- [~~$654_最大二叉树~~](python/stack/monotone_stack/$654_MaximumBinaryTree.py)(不用看了，不需要用单调栈解)
- [$901_股票价格跨度](python/stack/monotone_stack/$901_OnlineStockSpan.py)(单减栈，最前面添加一个最大值的哨兵，记录每次出完栈的栈顶元素与当前元素的下标差)
- [$1944_队列中可以看到的人数](python/stack/monotone_stack/$1944_NumberOfVisiblePeopleInAQueue.py)(记录出栈后的索引差，栈弹出完后要注意是否是空栈)
- [~~$1081_不同字符的最小子序列~~](python/stack/monotone_stack/$1081_SmallestSubsequenceOfDistinctCharacters.py)(和316一样)
- [$907_子数组的最小值之和](python/stack/monotone_stack/$907_SumOfSubarrayMinimums.py)(钦定单调栈最难的一题)

# 大杂烩

- [$327_区间和的个数](java/src/main/java/cn/leetcode/binaryindexedtree/$327_CountOfRangeSum.java)(树状数组or归并排序or平衡树)

##### java

```java
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取 n m
        int n = scanner.nextInt(), m = scanner.nextInt();

        int[] nums = new int[n + 1];
        int[] pref = new int[n + 1];
        int[] mx = new int[n + 1];
        // 读入数组
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            pref[i] = pref[i - 1] + nums[i];
            mx[i] = Math.max(pref[i], mx[i - 1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            ans = Math.min(ans, pref[i] - mx[i - m]);
        }
        // 将结果输出到标准输出
        System.out.println(ans);
    }
}
```

##### python

```python
n, m = map(int, input().split())
a = [0] + list(map(int, input().split()))
pref = [0] * (n + 1)
mx = [0] * (n + 1)
for i in range(1, n + 1):
    pref[i] = pref[i - 1] + a[i]
    mx[i] = max(pref[i], mx[i - 1])
from functools import reduce

print(reduce(min, [pref[i] - mx[i - m] for i in range(m, n + 1)], 1 << 30))
```

##### cpp

```cpp
#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> a(n + 1);
  vector<int> pref(n + 1);
  vector<int> mx(n + 1);
  int ans = (1 << 30);
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    pref[i] = pref[i - 1] + a[i];
    mx[i] = max(mx[i - 1], pref[i]);
  }
  for (int i = m; i <= n; ++i) {
    ans = min(ans, pref[i] - mx[i - m]);
  }
  cout << ans << endl;
  return 0;
}
```
