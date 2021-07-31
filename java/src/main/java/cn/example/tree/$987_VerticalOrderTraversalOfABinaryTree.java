package cn.example.tree;

import cn.example.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class $987_VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> arr = new ArrayList<>();
        dfs(root, 0, 0, arr);
        Collections.sort(arr, new Comparator<int[]>(){
            public int compare(int[] tuple1, int[] tuple2){
                if(tuple1[0] != tuple2[0]){
                    return tuple1[0] - tuple2[0];
                }else if (tuple1[1] != tuple2[1]){
                    return tuple1[1] - tuple2[1];
                }else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = 0;
        int lastCol = Integer.MIN_VALUE;
        for (int[] tuple : arr) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastCol) {
                lastCol = col;
                res.add(new ArrayList<Integer>());
                size++;
            }
            res.get(size - 1).add(value);
        }
        return res;
    }


    public void dfs(TreeNode node, int row, int col, List<int[]> arr){
        if(node != null){
            arr.add(new int[]{col, row, node.val});
            dfs(node.left, row + 1, col - 1, arr);
            dfs(node.right, row + 1, col + 1, arr);
        }
    }
}
