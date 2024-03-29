package cn.leetcode.cache.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Stream {
    public void strList() {
        // List<String>
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        // Stream.of
        int a = Stream.of(2, 1, 4, 5, 3).max(Integer::compare).get();
        int b = Stream.of(2, 1, 4, 5, 3).min(Integer::compare).get();

        int c = Stream.of(1, 2, 4, 5, 3).mapToInt(i -> i).max().getAsInt();

        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        int res = list.stream().mapToInt(o -> o).max().getAsInt();

        // int[]
        int[] arr = new int[]{1, 3, 5};
        int val = Arrays.stream(arr).max().getAsInt();

    }
}
