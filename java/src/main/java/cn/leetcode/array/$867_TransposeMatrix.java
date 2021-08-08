package cn.leetcode.array;

class $867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int m=A.length,n=A[0].length;
        int[][] C=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[j][i]=A[i][j];
            }
        }
        return C;
    }
}
