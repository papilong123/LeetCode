
### 滑动窗口
- [$3_无重复字符的最长子串](/python/sliding_window/$3_LengthOfLongestSubstring.py)
- [$30_串联所有单词的子串](/python/sliding_window/$30_SubstringWithConcatenationOfAllWords.py)
- [$76_最小覆盖子串](/python/sliding_window/$76_MinimumWindowSubstring.py)
- [$159_至多包含两个不同字符的最长子串](/python/sliding_window/$159_LongestSubstringwithAtMostTwoDistinctCharacters.py)
- [$187_重复的DNA序列](/python/sliding_window/$187_RepeatedDNASequences.py)(更适合使用hashmap)
- [$209_长度最小的子数组](/python/sliding_window/$209_MinimumSizeSubarraySum.py)
- [$219_存在重复元素II](/python/sliding_window/$219_ContainsDuplicateII.py)(窗口长度固定)
- [$220_存在重复元素III](/python/sliding_window/$220_ContainsDuplicateIII.py)

### 单调栈

- [$20_有效的括号](/java/src/main/java/cn/leetcode/stack/$20_ValidParentheses.java)

### 动态规划

### dfs

### 二分查找

#### 输入输出

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
