package cn.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

// dfs加三色标记法
public class $802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph){
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n ; i++){
            if(dfs(graph, color, i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs(int[][] graph, int[] color, int x){
        if(color[x] > 0){
            return color[x] == 2;
        }
        color[x] = 1;
        for(int y : graph[x]){
            if(!(dfs(graph, color, y))){
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
