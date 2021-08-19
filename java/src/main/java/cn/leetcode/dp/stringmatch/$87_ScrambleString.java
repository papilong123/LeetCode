package cn.leetcode.dp.stringmatch;

public class $87_ScrambleString {
    String s1, s2;
    int[][][] cache;
    int N = -1, Y = 1, EMPTY = 0;

    public boolean isScramble(String _s1, String _s2) {
        //递归 + 记忆化搜索 定义cache[i][j][k] 为s1从i开始，后面的k位和s2从j开始后面的k位字符串是否形成扰乱字符串
        //所以需要定义s1和s2为全局变量
        this.s1 = _s1;
        this.s2 = _s2;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        //默认为EMPTY
        cache = new int[n][n][n + 1]; //前两位都是下标，后一位是长度，所以需要开辟n+1的空间
        return dfs(0, 0, n);
    }

    private boolean dfs(int i, int j, int len) {
        if (cache[i][j][len] != EMPTY) return cache[i][j][len] == Y;
        //根据定义，取出为s1从i开始，后面的len位和s2从j开始后面的len位
        String a = s1.substring(i, i + len), b = s2.substring(j, j + len);
        if (a.equals(b)) {
            cache[i][j][len] = Y;
            return true;
        }
        if (!check(a, b)) {
            cache[i][j][len] = N;
            return false;
        }
        //a 和 b 值不相等 且 出现的字符的频率相同，则需要进行判断
        //从s1和s2往后 1位开始比较到 length - 1位 所以k初始值位1
        for (int k = 1; k < len; k++) {
            //没有反转的情况下，i,j同序; 相当于s1[0,i)要匹配s2的[0,i) && s1[i,n)要匹配s2的[i,n);
            //那么需要比较s1从当前位置i往后k位，和s2从当前位置j往后k位 形成的是否为扰乱字符串
            //以及，从s1剩下的len - k 位，和s2剩下的len - k 位 形成的是否为扰乱字符串
            //以上两个条件必须同时满足
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
            //发生了反转的情况下， 相当于s1[0,i)要匹配s2的[n - i,n) && s1[i,n)要匹配s2的[0,n - i);
            //那么需要比较s1从当前位置i,往后k位,和s2从当前位置len - k + j (s2这里是从后面开始 反转后 后面的和前面的匹配，前面的和后面的匹配)
            //len - k + j 这个位置不好理解，同学们可以试着画图一看便知
            //以及 s1剩下的len - k位，和s2剩下的len - k位 (s2这里是从前面开始，也就是当前位置为 j)
            //以上两个条件必须同时满足
            if (dfs(i, len - k + j, k) && dfs(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }
        //以上两种情况验证过了以后还不成立
        cache[i][j][len] = N;
        return false;
    }

    // 检查 s1 和 s2 词频是否相同
    boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt1[cs1[i] - 'a']++;
            cnt2[cs2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }

    // 方法二、区间dp
    public boolean isScrambleDp(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        boolean[][][] f = new boolean[n][n][n + 1];

        // 先处理长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 再处理其余长度情况
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        if (a || b) {
                            f[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }

}
