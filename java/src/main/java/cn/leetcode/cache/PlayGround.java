package cn.leetcode.cache;

import cn.leetcode.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayGround extends BinaryTree {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        String str = "";
        arr.add(4);
        List<Integer> ans = arr.stream().filter(x -> x > 3).map(x -> x + 1).collect(Collectors.toList());
        char[] charArray = str.toCharArray();

        int[] a = {3, 7, 2, 8, 2, 6, 8};

        List<String> listA = Arrays.asList("dog", "cat", "cow");
        String[] strs = {"dog", "cat", "cow"};
        List<String> listB = Arrays.asList(strs);
        System.out.println(listA);
        System.out.println(listB);
    }

    public int f(int a) {
        int b = 1;
        a += 132;
        return a + 1;
    }
}
