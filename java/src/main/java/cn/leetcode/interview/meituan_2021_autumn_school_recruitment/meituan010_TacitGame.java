package cn.leetcode.interview.meituan_2021_autumn_school_recruitment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class meituan010_TacitGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        String[] seq = br.readLine().split(" ");
        br.close();

        int m = Integer.parseInt(info[0]);
        int n = Integer.parseInt(info[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(seq[i]);
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            int left = i, right = m + 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (check(arr, i, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res += m - left + 1;
            if (left == m + 1) {
                break;
            }
        }

        bw.write(String.valueOf(res));
        bw.close();
    }

    private static boolean check(int[] arr, int left, int right) {
        int pre = -1;

        for (int x : arr) {
            if (left > x || right < x) {
                if (x < pre) {
                    return false;
                }
                pre = x;
            }
        }

        return true;
    }
}
