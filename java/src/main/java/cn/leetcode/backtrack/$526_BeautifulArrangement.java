package cn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class $526_BeautifulArrangement {
    int res = 0;
    boolean[] used;
    List<Integer>[] match;

    public int countArrangement(int n) {
        used = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            match[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }

        backtrack(1, n);
        return res;
    }

    private void backtrack(int index, int n) {
        if (index > n) {
            res++;
            return;
        }

        for (int x : match[index]) {
            if (!used[x]) {
                used[x] = true;
                backtrack(index + 1, n);
                used[x] = false;
            }
        }
    }
}
