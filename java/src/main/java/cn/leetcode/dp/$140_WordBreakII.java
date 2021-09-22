package cn.leetcode.dp;

import java.util.*;

public class $140_WordBreakII {

    // 解法一、记忆化搜索 + 剪枝（官方解法）
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = dfs(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> breakList = new ArrayList<>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> dfs(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (map.containsKey(index)) {  // 记忆化
            return map.get(index);
        }

        List<List<String>> wordBreaks = new ArrayList<>();
        if (index == length) {  // 特殊情况，最后返回一个带有一个list的res
            wordBreaks.add(new ArrayList<>());
        }

        for (int i = index + 1; i <= length; i++) {
            String word = s.substring(index, i);
            if (wordSet.contains(word)) {  // 剪枝
                List<List<String>> nextWordBreaks = dfs(s, length, wordSet, i, map);
                for (List<String> nextWordBreak : nextWordBreaks) {  // 取出所有的数组，在每一个数组前加上当前单词
                    LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                    wordBreak.offerFirst(word);
                    wordBreaks.add(wordBreak);
                }
            }
        }

        map.put(index, wordBreaks);
        return map.get(index);
    }

    // 解法二、dp预处理+回溯（liweiwei1419）
    public List<String> wordBreakBacktrack(String s, List<String> wordDict) {
        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // 第 1 步：动态规划计算是否有解
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        // 长度包括 0 ，因此状态数组的长度为 len + 1
        boolean[] dp = new boolean[len + 1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int left = right - 1; left >= 0; left--) {
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                    break;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(len, s, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param s
     * @param len     长度为 len 的 s 的前缀子串
     * @param wordSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    private void dfs(int len, String s, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
            return;
        }

        // 可以拆分的左边界从 len - 1 依次枚举到 0
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(i, s, wordSet, dp, path, res); // 注意，这里i不变
                path.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<String>() {{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};
        List<String> res = new $140_WordBreakII().wordBreak("catsanddog", str);
        System.out.println(res);
    }

}
