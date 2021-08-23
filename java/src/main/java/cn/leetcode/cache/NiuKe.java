package cn.leetcode.cache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.TreeSet;

public class NiuKe {
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static TreeSet<Integer> bound = new TreeSet<>();
    static int[] prefix = new int[50050];

    public static void main(String[] args) throws Exception {
        // 加速 IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        String[] query = br.readLine().split(" ");
        br.close();

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + Integer.parseInt(arr[i]);
        }

        bound.add(0);
        bound.add(n + 1);
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(query[i]);
            var left = bound.lower(pos);
            var right = bound.higher(pos);
            // 消除警告
            if (left == null || right == null) {
                continue;
            }
            int seg_sum = prefix[right - 1] - prefix[left];
            var val = map.get(seg_sum);
            if (val != null) {
                if (val == 1) {
                    map.remove(seg_sum);
                } else {
                    map.put(seg_sum, val - 1);
                }
            }
            int left_sum = prefix[pos - 1] - prefix[left];
            int right_sum = prefix[right - 1] - prefix[pos];
            bound.add(pos);
            map.put(left_sum, map.getOrDefault(left_sum, 0) + 1);
            map.put(right_sum, map.getOrDefault(right_sum, 0) + 1);
            bw.write(map.lastKey() + "\n");
            // bw.write(new StringBuilder().append(map.lastKey()).append('\n').toString());
        }
        bw.close();
    }
}
