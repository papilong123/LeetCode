package cn.example.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class $39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        if(candidates.length == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>(length);
        dfs(candidates, length, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int length, int begin, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < length; i++){


            path.addLast(candidates[i]);

            dfs(candidates, length, i, target-candidates[i], path, res);

            path.removeLast();
        }
    }
}
