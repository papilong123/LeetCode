package cn.example.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class $1337_TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < m; i++){
//            二分查找
            int l = 0, r = n - 1, pos = -1;
            while(l <= r){
                int mid = (l + r) / 2;
                if(mat[i][mid] == 0){
                    r = mid - 1;
                }else{
                    pos = mid;
                    l = mid + 1;
                }
            }
            arr.add(new int[]{pos+1, i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> {
            if (pair1[0] != pair2[0]) {
                return pair1[0] - pair2[0];
            } else {
                return pair1[1] - pair2[1];
            }
        });

        for (int[] pair : arr) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        $1337_TheKWeakestRowsInAMatrix test = new $1337_TheKWeakestRowsInAMatrix();
        test.kWeakestRows(arr,3);
    }
}
