package cn.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class $847_ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        boolean[][] seen = new boolean[n][1 << n];
        //从每个节点作为起点，中间出队遍历处理时不受影响
        for(int i = 0; i < n; i++){
            q.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        while(!q.isEmpty()){
            int[] tuple = q.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if(mask == (1 << n) - 1){
                ans = dist;
                break;
            }
            //搜索相邻的节点
            for(int v : graph[u]){
                //将mask的第v位置设为1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    q.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        $847_ShortestPathVisitingAllNodes solution = new $847_ShortestPathVisitingAllNodes();
        int ans = solution.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}});
        System.out.println(ans);
    }
}
